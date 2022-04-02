package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.statisticalriskfactors

import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData

@Composable
fun StatisticalRiskFactorsList()  {
    return StatisticalRiskFactorsItem(items = listOf(
        CheckBoxData(
            checkBoxName = "Man och mellan 19 och 45 år",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Somatisk sjukdom",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Missbruk/Beroende",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Tidigare suicidförsök",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Ensamboende utan relationer",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Finns självmordsredskap tillgängligt",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Tidigare eller aktuell aggressivitet",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Psykisk sjukdom och dess svårighetsgrad/fas/samsjuklighet",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Reaktion på akuta livshändelser/seperation/dödsfall/kränkning",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "Hög ångestnivå/tankestörning/psykotiskt tänkande oavsett grundsjuk",
            checkBoxValue = false,
        ),

        )
    )
}