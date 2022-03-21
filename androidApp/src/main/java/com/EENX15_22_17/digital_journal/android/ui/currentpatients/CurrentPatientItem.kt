package com.EENX15_22_17.digital_journal.android.ui.currentpatients


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R

class CurrentPatientItem {

    @Composable
    fun PatientCard() {
        Box() {
            Card(
                modifier = Modifier
                    .padding(horizontal = 120.dp)
                    .fillMaxWidth()
                    .clickable { System.out.println("Navigera") }
            ) {
                Text(
                    text = "This is a card",
                    Modifier
                        .width(400.dp)
                        .background(Color(R.color.colorPrimary), RectangleShape)
                        .padding(16.dp)
                )
            }
        }
    }
}