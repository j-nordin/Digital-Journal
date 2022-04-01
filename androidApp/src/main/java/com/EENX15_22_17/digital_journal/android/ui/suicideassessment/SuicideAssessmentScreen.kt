package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            Text(
                text = "SUICIDBEDÖMNING",
                style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.ExtraBold),
                color = Color.Black,
                modifier = Modifier.padding(top = 40.dp, start = 15.dp, end = 20.dp),

                )

            SuicideStepsList()



        }
    }
}