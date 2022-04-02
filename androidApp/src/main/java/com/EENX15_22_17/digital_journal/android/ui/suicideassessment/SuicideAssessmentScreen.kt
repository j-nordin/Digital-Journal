package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.components_beta.TemplateSection
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors.ProtectiveFactorsList
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.statisticalriskfactors.StatisticalRiskFactorsList
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.summarysuicidesection.SummarySuicide

@Composable
fun SuicideAssessmentScreen() {
    val scrollState = rememberScrollState()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),

        ) {
        Column (
            modifier = Modifier.verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center
        ) {
            // Page title
            Text(
                text = "SUICIDBEDÖMNING",
                style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.ExtraBold),
                color = Color.Black,
                modifier = Modifier.padding(top = 40.dp, start = 15.dp, end = 20.dp),

                )
            //Header checkbox
            Column(Modifier.padding(start = 40.dp, top = 10.dp)) {
                DrawCheckBoxes(items = listOf(
                    CheckBoxData("Medveten suicidbenägenhet framgår inte vid ankomstsamtal", false),
                    CheckBoxData("Patienten svarar inte på frågor", false),
                ))
            }
            //Suicid steps
            TemplateSection("Suicidstegen") { SuicideStepsList() }
            // Statistical Risk Factors
            TemplateSection("Statistiska riskfaktorer") { StatisticalRiskFactorsList() }
            // Protective factors & Summary of suicide assessment
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth(0.50f)
                ) {
                    TemplateSection(title = "Skyddande faktorer") { ProtectiveFactorsList() }
                }
                Column(

                ) {
                    TemplateSection(title = "Summering") { SummarySuicide() }
                }
            }


        }
    }
}