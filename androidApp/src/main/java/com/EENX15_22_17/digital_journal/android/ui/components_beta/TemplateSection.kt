package com.EENX15_22_17.digital_journal.android.ui.components_beta

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray

@Composable
fun TemplateSection(title: String, body: @Composable() () -> Unit ) {
    Box (
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp, top = 10.dp) ){
        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)

        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, colorTextGray), shape = RoundedCornerShape(5))
                    .padding(top = 10.dp)) {
                // Content
                Column(
                    Modifier.padding(20.dp)
                ) {
                    //SuicideStepsList()
                    body()
                }

            }
        }
        // Title
        Column(modifier = Modifier
            .padding(start = 20.dp)) {
            Column(modifier = Modifier
                .background(Color.White)) {
                Text(
                    text = " $title ",
                    style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.SemiBold),
                    color = Color.Black,

                    )
            }
        }


    }

}