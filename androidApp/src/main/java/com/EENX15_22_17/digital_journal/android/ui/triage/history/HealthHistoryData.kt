package com.EENX15_22_17.digital_journal.android.ui.triage.history


enum class SomaticHealthData {
    EARLIERHEALTHY,
    DELIRIUM,
    CARDIOVASCULAR,
    EP,
    CEREBROVASCULAR,
    LIVERFAILURE,
    TABLET,
    OPERATION,
    HEARTFAILURE,
    KIDNEYFAILURE,
    LUNGDISEASE,
    DIABETES,
    INSULIN,
    BLEEDINGDISORDER,
    MALIGNANCY,
    OTHER
}

val somaticHealthValues = mapOf<SomaticHealthData, String>(
    SomaticHealthData.EARLIERHEALTHY to "Tidigare väs frisk",
    SomaticHealthData.DELIRIUM to "Delirium",
    SomaticHealthData.CARDIOVASCULAR to "Kardiovaskulär sjukdom",
    SomaticHealthData.EP to "EP/abstinens EP",
    SomaticHealthData.CEREBROVASCULAR to "Cerebroveaskulär sjukdom",
    SomaticHealthData.LIVERFAILURE to "Leversvikt",
    SomaticHealthData.TABLET to "Tablett",
    SomaticHealthData.OPERATION to "Operation inom 3 månader",
    SomaticHealthData.HEARTFAILURE to "Hjärtsvikt",
    SomaticHealthData.KIDNEYFAILURE to "Njursvikt",
    SomaticHealthData.LUNGDISEASE to "Lungsjukdom",
    SomaticHealthData.DIABETES to "Diabetes",
    SomaticHealthData.INSULIN to "Insulin",
    SomaticHealthData.BLEEDINGDISORDER to "Blödningssjukdom/AK-behandling",
    SomaticHealthData.MALIGNANCY to "Malignitet",
    SomaticHealthData.OTHER to "Övrigt"
)

