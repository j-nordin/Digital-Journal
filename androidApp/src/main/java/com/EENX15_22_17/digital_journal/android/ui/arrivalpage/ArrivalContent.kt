package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import androidx.compose.foundation.layout.*
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

// TODO: Fråga Rickard om hur man ska göra med Booleans för RadioButtons.
@Composable
fun Identity(
    setIdentity: (isIdentified: String) -> Unit
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
            setRadioValue = setIdentity
        )
    }
}

@Composable
fun Samsa(
    setSamsa: (hasSamsa: String) -> Unit,
) {
    Column {
        Text(
            text = stringResource(id = R.string.samsa),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        RadioButtonComponentBoolean(
            radioOptions = listOf("Ja", "Nej"),
            setRadioValue = setSamsa
        )
    }
}

@Composable
fun Relative(
    setRelativeName: (relativeName: String) -> Unit,
    relativeName: String,
    setRelativePhoneNumber: (relativeNumber: String) -> Unit,
    relativePhoneNumber: String
) {
    Column {
        Text(
            text = stringResource(id = R.string.relative),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Row (
            horizontalArrangement = Arrangement.spacedBy(20.dp)
                ){
            TitledTextField(
                title = stringResource(id = R.string.relativeName),
                onChangeText = setRelativeName,
                textValue = relativeName
            )
            TitledTextField(
                title = stringResource(id = R.string.relativePhoneNumber),
                onChangeText = setRelativePhoneNumber,
                textValue = relativePhoneNumber
            )
        }
    }
}