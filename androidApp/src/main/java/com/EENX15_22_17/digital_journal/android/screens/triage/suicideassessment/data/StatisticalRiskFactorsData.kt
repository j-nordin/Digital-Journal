package com.EENX15_22_17.digital_journal.android.screens.triage.suicideassessment.statisticalriskfactors

enum class StatisticalRiskFactorsData {
    IS_MALE_AGE_BETWEEN_19_AND_45,
    SOMATIC_DISEASE,
    MISUSE_OR_ADDICTION,
    PREVIOUS_SUICIDE_ATTEMPTS,
    LIVING_ALONE_WITHOUT_RELATIONS,
    SUICIDE_EQUIPMENT_IS_AVAILABLE,
    PREVIOUS_OR_CURRENT_AGGRESSION_OR_IMPULSIVE_BEHAVIOUR,
    PSYCHOLOGICAL_DISEASE_AND_COMORBIDITY,
    REACTION_ON_ACUTE_LIFE_EVENTS_SEPARATIONS_DEATH_OR_VIOLATION,
    HIGH_LEVEL_OF_ANXIETY_THOUGHT_DISORDER_PSYCHOTIC_THINKING_REGARDLESS_OF_UNDERLYING_DISEASE,
}

val statisticalRiskFactorsLabels = mapOf<StatisticalRiskFactorsData, String>(
    StatisticalRiskFactorsData.IS_MALE_AGE_BETWEEN_19_AND_45 to "Man och mellan 19 och 45 år",
    StatisticalRiskFactorsData.SOMATIC_DISEASE to "Somatisk sjukdom",
    StatisticalRiskFactorsData.MISUSE_OR_ADDICTION to "Missbruk/Beroende",
    StatisticalRiskFactorsData.PREVIOUS_SUICIDE_ATTEMPTS to "Tidigare suicidförsök",
    StatisticalRiskFactorsData.LIVING_ALONE_WITHOUT_RELATIONS to "Ensamboende utan relationer",
    StatisticalRiskFactorsData.SUICIDE_EQUIPMENT_IS_AVAILABLE to "Finns självmordsredskap tillgängligt",
    StatisticalRiskFactorsData.PREVIOUS_OR_CURRENT_AGGRESSION_OR_IMPULSIVE_BEHAVIOUR to "Tidigare eller aktuell aggressivitet",
    StatisticalRiskFactorsData.PSYCHOLOGICAL_DISEASE_AND_COMORBIDITY to "Psykisk sjukdom och dess svårighetsgrad/fas/samsjuklighet",
    StatisticalRiskFactorsData.REACTION_ON_ACUTE_LIFE_EVENTS_SEPARATIONS_DEATH_OR_VIOLATION to "Reaktion på akuta livshändelser/seperation/dödsfall/kränkning",
    StatisticalRiskFactorsData.HIGH_LEVEL_OF_ANXIETY_THOUGHT_DISORDER_PSYCHOTIC_THINKING_REGARDLESS_OF_UNDERLYING_DISEASE to "Hög ångestnivå/tankestörning/psykotiskt tänkande oavsett grundsjuk",
)
