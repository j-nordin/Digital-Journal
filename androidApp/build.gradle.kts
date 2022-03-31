val compose_version: String by project

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.EENX15_22_17.digital_journal.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose_version
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:$compose_version")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.ui:ui:1.2.0-alpha03")
    implementation("androidx.activity:activity-compose:1.5.0-alpha02")
    implementation("androidx.navigation:navigation-compose:2.4.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.0-alpha03")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("androidx.navigation:navigation-compose:2.4.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.0-alpha03")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    androidTestImplementation("junit:junit:4.13.2")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_version")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    implementation("androidx.compose.ui:ui-test-junit4:$compose_version")
    implementation ("androidx.compose.material:material-icons-extended:$compose_version")

    //Preview Composables
    debugImplementation ("androidx.compose.ui:ui-tooling:1.1.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.1.1")
}