package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components_beta.TitledSection
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.SuicideAssessmentModel
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.summarysuicidesection.SummarySection
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun SuicideAssessmentScreen(
    onBackClicked: () -> Unit = {},
    onMenuClicked: () -> Unit = {},
) {
    DetailPageWrapper(
        title = "SUICIDBEDÖMNING", // TODO: Use `JournalScreen.ACTIONS_AND_ORDINATIONS.title` when libs are available,
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(verticalArrangement = Arrangement.Center) {

                //Header checkbox
                Column(Modifier.padding(start = 20.dp, top = 20.dp)) {
                    SuicideAssessmentModel(
                        choices = headerCheckboxesValues.keys.toTypedArray(),
                        onChange = { },
                        currentSelected = emptySet(),
                        labels = headerCheckboxesValues
                    )
                }
                //Suicid steps
                TitledSection("Suicidstegen") { SuicideStepsContent() }
                // Statistical Risk Factors
                TitledSection("Statistiska riskfaktorer") { StatisticalRiskFactorsContent() }
                // Protective factors & Summary of suicide assessment
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth()
                ) {

                    Column(modifier = Modifier.fillMaxWidth(0.50f)) {
                        TitledSection(title = "Skyddande faktorer") { ProtectiveFactorsContent() }
                    }
                    Column(Modifier.padding(start = 20.dp)) {
                        TitledSection(title = "Summering") { SummarySection() }
                    }
                }


            }
        }
    }

}