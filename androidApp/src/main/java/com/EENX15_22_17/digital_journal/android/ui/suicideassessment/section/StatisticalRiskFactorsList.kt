package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.statisticalriskfactors

import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData


fun StatisticalRiskFactorsList(): List<CheckBoxData> {
    return listOf(
        CheckBoxData(
            checkBoxName = "Man och mellan 19 och 45 år",
            checkBoxValue = false,
            checkBoxId = "male_between_19_and_45"
        ),
        CheckBoxData(
            checkBoxName = "Somatisk sjukdom",
            checkBoxValue = false,
            checkBoxId = "somatic_disease"

        ),
        CheckBoxData(
            checkBoxName = "Missbruk/Beroende",
            checkBoxValue = false,
            checkBoxId = "substance_abuse"
        ),
        CheckBoxData(
            checkBoxName = "Tidigare suicidförsök",
            checkBoxValue = false,
            checkBoxId = "previous_suicide_attempts"
        ),
        CheckBoxData(
            checkBoxName = "Ensamboende utan relationer",
            checkBoxValue = false,
            checkBoxId = "living_alone"
        ),
        CheckBoxData(
            checkBoxName = "Finns självmordsredskap tillgängligt",
            checkBoxValue = false,
            checkBoxId = "suicide_tools_available"
        ),
        CheckBoxData(
            checkBoxName = "Tidigare eller aktuell aggressivitet",
            checkBoxValue = false,
            checkBoxId = "past_current_aggression"
        ),
        CheckBoxData(
            checkBoxName = "Psykisk sjukdom och dess svårighetsgrad/fas/samsjuklighet",
            checkBoxValue = false,
            checkBoxId = "mental_illness_difficulties"
        ),
        CheckBoxData(
            checkBoxName = "Reaktion på akuta livshändelser/seperation/dödsfall/kränkning",
            checkBoxValue = false,
            checkBoxId = "acute_life_events"
        ),
        CheckBoxData(
            checkBoxName = "Hög ångestnivå/tankestörning/psykotiskt tänkande oavsett grundsjuk",
            checkBoxValue = false,
            checkBoxId = "high_anxiety_level"
        ),

    )
}