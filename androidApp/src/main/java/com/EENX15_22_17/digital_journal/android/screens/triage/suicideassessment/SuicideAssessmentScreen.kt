package com.EENX15_22_17.digital_journal.android.screens.triage.suicideassessment

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSectionTemp
import com.EENX15_22_17.digital_journal.android.screens.triage.suicideassessment.protectivefactors.SuicideAssessmentModel
import com.EENX15_22_17.digital_journal.android.screens.triage.suicideassessment.summarysuicidesection.SummarySection
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun SuicideAssessmentScreen(
    onBackClicked: () -> Unit,
    visitId: String
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.suicideAssessment),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = {}
    ) {
       Column(verticalArrangement = Arrangement.Center) {

                //Header checkbox
                Column(Modifier.padding(start = 20.dp, top = 20.dp)) {
                    SuicideAssessmentModel(
                        choices = headerCheckboxesLabels.keys.toTypedArray(),
                        onChange = { },
                        currentSelected = emptySet(),
                        labels = headerCheckboxesLabels
                    )
                }
                //Suicide steps
                TitledSectionTemp("Suicidstegen") { SuicideStepsContent() }
                // Statistical Risk Factors
                TitledSectionTemp("Statistiska riskfaktorer") { StatisticalRiskFactorsContent() }
                // Protective factors & Summary of suicide assessment
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(modifier = Modifier.fillMaxWidth(0.50f)) {
                        TitledSectionTemp(title = "Skyddande faktorer") { ProtectiveFactorsContent() }
                    }
                    Column(Modifier.padding(start = 20.dp)) {
                        TitledSectionTemp(title = "Summering") { SummarySection() }
                    }
                }

            }
    }

}