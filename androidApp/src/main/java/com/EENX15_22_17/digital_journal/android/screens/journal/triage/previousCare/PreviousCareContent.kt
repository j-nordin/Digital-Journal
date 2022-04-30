package com.EENX15_22_17.digital_journal.android.screens.journal.triage.previousCare

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.components.*
import se.predicare.journal.screens.PreviousCareDto

@Composable
fun previousHealthCare(item: PreviousCareDto) {
    Column() {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            LabeledRadioButton(
                label = "Ja", //TODO: Use PreviousCareDto
                checked = false,
                onCheckedChange = {}, //TODO: Implement View Model for previouscare Cause
            )
            TitledTextField(
                title = "Via",
                onChangeText = {}, //TODO: Implement View Model for previouscare Cause
                textValue = "",
                modifier = Modifier.padding(start = 10.dp, end = 10.dp).size(width = 200.dp, height = 60.dp)
            )

            LabeledRadioButton(
                label = "Nej", //TODO: Use PreviousCareDto
                checked = false,
                onCheckedChange = {}
            )

        }
        TitledTextField(
            title = "Aktuell behandling",
            onChangeText = {}, //TODO: Implement View Model for previouscare Cause
            textValue = "",
            modifier = Modifier.padding(top = 20.dp).size(width = 500.dp, height = 60.dp)
        )
        visitTime(items = item, title = "Senast besöket")
        visitTime(items = item, title = "Senast besöket")
    }

}

@Composable
fun visitTime(items: PreviousCareDto, title: String) {

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.size(height = 100.dp, width = 250.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.CalendarMonth,
                contentDescription = "calendar",
                modifier = Modifier.size(42.dp).padding(end = 10.dp),
                tint = Color.Gray
            )

            TitledSection(title = title) {} //TODO: Replace this with a really calendar (from Jonas)

        }
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitledTextField(
                title = "Behandlare",
                onChangeText = {}, //TODO: Implement View Model for previouscare Cause
                textValue = "",
                modifier = Modifier.padding(start = 10.dp).size(width = 200.dp, height = 60.dp)
            )
            TitledTextField(
                title = "Titel",
                onChangeText = {}, //TODO: Implement View Model for previouscare Cause
                textValue = "",
                modifier = Modifier.padding(start = 10.dp).size(width = 200.dp, height = 60.dp)
            )
        }
    }

}

@Composable
fun previousJournalInPsychiatry(item: PreviousCareDto) {
    Column() {
        Row() {
            Row() {
                LabeledRadioButton(
                    label = "Ja", //TODO: Use PreviousCareDto
                    checked = false,
                    onCheckedChange = {}, //TODO: Implement View Model for previouscare Cause
                )
                Box(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
                    LabeledRadioButton(
                        label = "Nej", //TODO: Use PreviousCareDto
                        checked = false,
                        onCheckedChange = {}, //TODO: Implement View Model for previouscare Cause
                    )
                }
                LabeledRadioButton(
                    label = "Oklar", //TODO: Use PreviousCareDto
                    checked = false,
                    onCheckedChange = {}, //TODO: Implement View Model for previouscare Cause
                )
            }

            TitledTextField(
                title = "Var",
                onChangeText = {}, //TODO: Implement View Model for previouscare Cause
                textValue = "",
                modifier = Modifier.padding(start = 100.dp, end = 10.dp).size(width = 200.dp, height = 60.dp)
            )

        }
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Medgivande NPÖ")
            Row() {
                LabeledRadioButton(
                    label = "Ja", //TODO: Use PreviousCareDto
                    checked = false,
                    onCheckedChange = {}, //TODO: Implement View Model for previouscare Cause
                )
                Box(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
                    LabeledRadioButton(
                        label = "Nej", //TODO: Use PreviousCareDto
                        checked = false,
                        onCheckedChange = {}, //TODO: Implement View Model for previouscare Cause
                    )
                }
            }
        }
    }
}