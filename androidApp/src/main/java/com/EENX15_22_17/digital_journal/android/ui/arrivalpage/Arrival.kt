package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextFieldDigitKeyboard

@Composable
fun ArrivalContent(
    arrivalViewModel: ArrivalViewModel = ArrivalViewModel()
) {
    Row(
        Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DateField(
            date = arrivalViewModel.getTimestamp())
        ArrivalTime(
            setTimestamp =  {
                arrivalViewModel.arrivalStates.timestamp = it
                println( arrivalViewModel.arrivalStates.timestamp)
            },
            timeStamp = arrivalViewModel.arrivalStates.timestamp
        )
        EssNumber(
            setEssNumber = {
            arrivalViewModel.arrivalStates.ess = it
            println(arrivalViewModel.arrivalStates.ess)
        },
            arrivalViewModel.arrivalStates.ess
        )
    }
}

@Composable
fun DateField(date : String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.CalendarToday,
            contentDescription = "calendar",
            modifier = Modifier.padding()
        )
        // TODO: Date readOnly text field
        Text(
            text = date,
            fontSize = 30.sp
        )
    }
}

@Composable
fun ArrivalTime(setTimestamp: (ts: String) -> Unit, timeStamp: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Timer,
            contentDescription = "calendar",
            modifier = Modifier.padding(top = 25.dp)
        )
        TitledTextFieldDigitKeyboard(
            title = stringResource(id = R.string.arrivalTime),
            onChangeText = {
                 setTimestamp(it)
            },
            textValue = timeStamp
        )
    }
}

@Composable
fun EssNumber(setEssNumber: (ess: String) -> Unit, essNumber: String) {
    TitledTextFieldDigitKeyboard(
        title = stringResource(id = R.string.essNumber),
        onChangeText = {
            //TODO: Fix so ess not a string
            setEssNumber(it)
        },
        textValue = essNumber
    )
}
