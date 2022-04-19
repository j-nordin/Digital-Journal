plugins {
    // Plugin to read credentials from maven configuration.
    // The plugin must also be specified in subprojects.
    id("net.linguica.maven-settings") version "0.5"
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:7.1.3")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://pkgs.dev.azure.com/predicare/_packaging/retts-ng/maven/v1")
            name = "retts-ng"
            // Credentials are read from `$HOME/.m2/settings.xml`.
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}