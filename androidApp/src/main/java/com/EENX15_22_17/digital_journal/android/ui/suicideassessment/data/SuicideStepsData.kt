package com.EENX15_22_17.digital_journal.android.ui.suicideassessment


enum class HeaderCheckboxesData {
    CONSCIOUS_SUICIDAL_THOUGHTS_ARENOT_APPARENT_DURING_ARRIVAL_CONVERSATION,
    THE_PATIENT_DOESNOT_ANSWER_QUESTIONS,
}

val headerCheckboxesValues = mapOf<HeaderCheckboxesData, String>(
    HeaderCheckboxesData.CONSCIOUS_SUICIDAL_THOUGHTS_ARENOT_APPARENT_DURING_ARRIVAL_CONVERSATION to "Medveten suicidbenägenhet framgår inte vid ankomstsamtal",
    HeaderCheckboxesData.THE_PATIENT_DOESNOT_ANSWER_QUESTIONS to "Patienten svarar inte på frågor",
)

enum class SuicideStepsData {
    DEPRESSION,
    DEATH_THOUGHTS,
    DEATH_WISH,
    SUICIDAL_THOUGHTS,
    SUICIDE_IMPULSES,
    SUICIDE_INTENTIONS,
    SUICIDE_ACT,
}

val suicideStepsValues = mapOf<SuicideStepsData, String>(
    SuicideStepsData.DEPRESSION to "1. Nedstämdhet",
    SuicideStepsData.DEATH_THOUGHTS to "2. Livsleda, dödstankar",
    SuicideStepsData.DEATH_WISH to "3. Dödsönskan",
    SuicideStepsData.SUICIDAL_THOUGHTS to "4. Suicidtankar",
    SuicideStepsData.SUICIDE_IMPULSES to "5. Suicidimpulser",
    SuicideStepsData.SUICIDE_INTENTIONS to "6. Suicidala avsikter eller planer",
    SuicideStepsData.SUICIDE_ACT to "7. Suicidhandling",

    )

