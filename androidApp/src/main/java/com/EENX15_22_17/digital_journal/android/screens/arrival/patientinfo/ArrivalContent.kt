package com.EENX15_22_17.digital_journal.android.screens.arrival.patientinfo

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.dataModel.YesAndNoAndNoAnswer
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoLabels
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoNoAnswerLabels
import com.EENX15_22_17.digital_journal.android.ui.components.*
import com.EENX15_22_17.digital_journal.android.ui.theme.danger


@Composable
fun DateField(date: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 10.dp)
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
            onChangeText = { setTimestamp(it) },
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
fun BelongingsContent(
    noBelongings: Boolean,
    onHospital: Boolean,
    byRelative: Boolean,
    lockNumber: String,
    onLockNumberChange: (lockNumber: String) -> Unit,
    signature: String,
    onSignatureChange: (sign: String) -> Unit
) {
    var noBelongingsChecked by rememberSaveable { mutableStateOf(noBelongings) }
    var inHospitalChecked by rememberSaveable { mutableStateOf(onHospital) }
    var byRelativeChecked by rememberSaveable { mutableStateOf(byRelative) }
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row {
            LabeledCheckbox(
                label = "Finns inga på akutmottagningen",
                checked = noBelongingsChecked,
                onCheckedChange = { noBelongingsChecked = it }
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
            LabeledCheckbox(
                label = "Lämnat på akutmottagningen",
                checked = inHospitalChecked,
                onCheckedChange = { inHospitalChecked = it }
            )
            TitledTextField(
                title = "Skåpsnummer",
                onChangeText = onLockNumberChange,
                textValue = lockNumber,
                isEnabled = inHospitalChecked
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
            LabeledCheckbox(
                label = "Lämnat till anhörig/signering",
                checked = byRelativeChecked,
                onCheckedChange = { byRelativeChecked = it }
            )
            TitledTextField(
                title = "Signering",
                onChangeText = onSignatureChange,
                textValue = signature,
                isEnabled = byRelativeChecked
            )
        }
    }

}

@Composable
fun Secrecy(
    value: YesAndNoAndNoAnswer,
    onChange: (value: YesAndNoAndNoAnswer) -> Unit
) {
    EnumRadioButtonsHorizontal(
        choices = yesNoNoAnswerLabels.keys.toTypedArray(),
        labels = yesNoNoAnswerLabels,
        currentChoice = value,
        onSelection = onChange
    )
}

@Composable
fun SecrecyReservation(
    setSecrecyReservation: (reservation: String) -> Unit,
    reservation: String
) {
    TitledTextField(
        title = stringResource(id = R.string.reservation),
        textValue = reservation,
        onChangeText = { setSecrecyReservation(it) }
    )
}

// TODO: Fråga Rickard om hur man ska göra med Booleans för RadioButtons.
@Composable
fun Identity(
    value: YesNo,
    onChange: (identity: YesNo) -> Unit
) {
    EnumRadioButtonsHorizontal(
        choices = yesNoLabels.keys.toTypedArray(),
        labels = yesNoLabels,
        currentChoice = value,
        onSelection = onChange
    )
}

@Composable
fun Samsa(
    value: YesNo,
    onChange: (samsa: YesNo) -> Unit

) {
    EnumRadioButtonsHorizontal(
        choices = yesNoLabels.keys.toTypedArray(),
        labels = yesNoLabels,
        currentChoice = value,
        onSelection = onChange
    )
}

@Composable
fun Relative(
    setRelativeName: (relativeName: String) -> Unit,
    relativeName: String,
    setRelativePhoneNumber: (relativeNumber: String) -> Unit,
    relativePhoneNumber: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TitledTextField(
            title = stringResource(id = R.string.relativeName),
            onChangeText = setRelativeName,
            textValue = relativeName
        )
        TitledTextFieldDigitKeyboard(
            title = stringResource(id = R.string.relativePhoneNumber),
            onChangeText = setRelativePhoneNumber,
            textValue = relativePhoneNumber
        )
    }
}

@Composable
fun ChildrenInHouseHold(
    onChange: (age: List<String>) -> Unit,
    values: List<String>,
    onConcernReportChange: (value: YesNo) -> Unit,
    concernReport: YesNo
) {
    var hasChildren by rememberSaveable { mutableStateOf(YesNo.UNKOWN) }
    Row {
        Column {
            Text(
                text = stringResource(id = R.string.childrenInHouseHold),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            EnumRadioButtonsHorizontal(
                choices = yesNoLabels.keys.toTypedArray(),
                labels = yesNoLabels,
                currentChoice = hasChildren,
                onSelection = { hasChildren = it }
            )
        }
        if (hasChildren == YesNo.YES) {
            AddChildren(
                onAgeChange = onChange,
                ageValues = values
            )
            ConcernReport(
                value = concernReport,
                onChange = onConcernReportChange
            )
        }
    }
}

@Composable
fun AddChildren(
    onAgeChange: (age: List<String>) -> Unit,
    ageValues: List<String>
) {
    var ageList by rememberSaveable { mutableStateOf(ageValues) }
    var age by rememberSaveable { mutableStateOf("") }
    var warningMessage by remember { mutableStateOf("") }

    Row {
        Column {
            TitledTextFieldDigitKeyboard(
                title = stringResource(id = R.string.childrenAge),
                textValue = age,
                onChangeText = {
                    warningMessage = ""
                    age = it
                }
            )
            Button(
                onClick = {
                    when {
                        age.isDigitsOnly() -> {
                            val newList = ageList.toMutableList()
                            newList.add(age)
                            ageList = newList
                            onAgeChange(ageList)
                        }
                        else -> {
                            warningMessage = "Måste vara en siffra"
                        }
                    }
                }
            ) {
                Text(text = stringResource(id = R.string.addChild))
            }
            Text(
                text = warningMessage,
                color = danger
            )
        }
        ChildrenAgeList(ageList)
    }

}

@Composable
private fun ChildrenAgeList(
    ageList: List<String>
) {
    Column(
        modifier = Modifier.padding(4.dp)
    ) {
        ageList.forEach { age ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 2.dp)
                    .fillMaxWidth(0.3f),
                elevation = 4.dp
            ) {
                Text(
                    text = "$age år",
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Composable
fun ConcernReport(
    value: YesNo,
    onChange: (report: YesNo) -> Unit
) {
    Column {
        Text(
            text = stringResource(id = R.string.concernReport),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        EnumRadioButtonsHorizontal(
            choices = yesNoLabels.keys.toTypedArray(),
            labels = yesNoLabels,
            currentChoice = value,
            onSelection = onChange
        )
    }
}
