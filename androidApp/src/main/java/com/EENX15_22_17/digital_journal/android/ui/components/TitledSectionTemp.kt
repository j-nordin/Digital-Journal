package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun TitledSectionTemp(title: String, body: @Composable() () -> Unit) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp, top = 10.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, colorTextGray), shape = RoundedCornerShape(5))
                    .padding(top = 10.dp)
            ) {
                // Content
                Column(Modifier.padding(20.dp)) { body() }

            }
        }
        //TODO: Place the Title composable on top : This issue is solved by Axel. (Wait for merge)
        Column(modifier = Modifier.padding(start = 20.dp)) {
            Column(
                modifier = Modifier
                    .background(Color.White)
            ) {
                Text(
                    text = " $title ",
                    style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.SemiBold),
                    color = Color.Black,

                    )
            }
        }


    }

}