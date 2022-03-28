package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.components.RadioButtonComponent
import com.EENX15_22_17.digital_journal.android.ui.components.RadioButtonComponentBoolean
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextFieldDigitKeyboard
import com.EENX15_22_17.digital_journal.android.ui.theme.borderColor

@Composable
fun ArrivalContent(
    arrivalViewModel: ArrivalViewModel = ArrivalViewModel()
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    border = BorderStroke(
                        2.dp,
                        borderColor
                    ),
                    shape = CircleShape
                )
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            DateField(
                date = arrivalViewModel.getTimestamp()
            )
            ArrivalTime(
                setTimestamp = {
                    arrivalViewModel.arrivalStates.timestamp = it
                    println(arrivalViewModel.arrivalStates.timestamp)
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    border = BorderStroke(
                        2.dp,
                        borderColor
                    ),
                    shape = CircleShape
                )
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Secrecy(
                setRadioValue = {
                    arrivalViewModel.arrivalStates.secrecy = arrivalViewModel.getEnumType(it)
                },
                radioStringValue = arrivalViewModel.getEnumString(arrivalViewModel.arrivalStates.secrecy)
            )

            SecrecyReservation(
                setSecrecyReservation = { arrivalViewModel.arrivalStates.reservation = it },
                reservation = arrivalViewModel.arrivalStates.reservation
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    border = BorderStroke(
                        2.dp,
                        borderColor
                    ),
                    shape = CircleShape
                )
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Identity(
                setIdentity = {
                    arrivalViewModel.arrivalStates.confirmedIdentity = arrivalViewModel.getBooleanValue(it)
                    println(arrivalViewModel.arrivalStates.confirmedIdentity)},
                identity = arrivalViewModel.arrivalStates.confirmedIdentity)
        }
    }
}

@Composable
fun DateField(date: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 25.dp)
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

@Composable
fun Secrecy(
    setRadioValue: (a: String) -> Unit,
    radioStringValue: String,
) {
    Column {
        Text(
            text = stringResource(id = R.string.secrecy),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        RadioButtonComponent(
            radioOptions = listOf("Ja", "Nej", "Inget svar"),
            setRadioValue = setRadioValue,
            radioStringValue = radioStringValue
        )
    }
}

@Composable
fun SecrecyReservation(
    setSecrecyReservation: (reservation: String) -> Unit,
    reservation: String
) {
    Box(
        modifier = Modifier.padding(start = 40.dp, top = 40.dp)
    ) {
        TitledTextField(
            title = stringResource(id = R.string.reservation),
            textValue = reservation,
            onChangeText = { setSecrecyReservation(it) }
        )
    }
}

@Composable
fun Identity (
    setIdentity: (isIdentified: String) -> Unit,
    identity: Boolean
) {

    Column {
        Text(
            text = stringResource(id = R.string.identity),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        RadioButtonComponentBoolean(
            radioOptions = listOf("Ja", "Nej"),
            setRadioValue = setIdentity,
            radioBooleanValue = identity
        )
    }

}
