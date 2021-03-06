package com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment.protectivefactors.SuicideAssessmentModel
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment.summarysuicidesection.SummarySection
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSection
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun SuicideAssessmentScreen(
    journalId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.suicideAssessment),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
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
                TitledSection("Suicidstegen") { SuicideStepsContent() }
                // Statistical Risk Factors
                TitledSection("Statistiska riskfaktorer") { StatisticalRiskFactorsContent() }
                // Protective factors & Summary of suicide assessment
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxWidth()
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