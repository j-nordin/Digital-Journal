package com.EENX15_22_17.digital_journal.android.screens.journal.arrival.patientInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.EnumRadioButtonsHorizontal
import com.EENX15_22_17.digital_journal.android.ui.components.LabeledCheckbox
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSection
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import kotlinx.datetime.*
import se.predicare.journal.data.Labels.labels
import se.predicare.journal.data.YesNoQuestion
import se.predicare.journal.screens.PatientInformationDto

data class Time(
    val hour: Int,
    val minute: Int,
    val second: Int
) {
    override fun toString(): String = "$hour:$minute:$second"
}

fun parseTime(hourMinute: String): Time? {
    val parts = hourMinute.split(":").map { it.toIntOrNull() }
    return when (parts.size) {
        1 -> Time(parts[0] ?: 0, 0, 0)
        2 -> Time(parts[0] ?: 0, parts[1] ?: 0, 0)
        3 -> Time(parts[0] ?: 0, parts[1] ?: 0, parts[2] ?: 0)
        else -> null
    }
}

fun Instant.getTime(): Time {
    val localDateTime = this.toLocalDateTime(TimeZone.currentSystemDefault()).toJavaLocalDateTime()
    return Time(localDateTime.hour, localDateTime.minute, localDateTime.second)
}

fun Instant.setTime(time: Time) {
    val localDateTime = this.toLocalDateTime(TimeZone.currentSystemDefault()).toJavaLocalDateTime()
    return with(localDateTime) {
        LocalDateTime(year, month, dayOfMonth, time.hour, time.minute, time.second)
    }
}

@Composable
fun PatientInfoScreen(
    vm: PatientInfoViewModel,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {

    var arrivalTime by vm.data.stateOf(PatientInformationDto::arrivalTime)
    var ess by vm.data.stateOf(PatientInformationDto::ess, mutableSetOf())
    var belongings by vm.data.stateOf(
        PatientInformationDto::belongings,
        PatientInformationDto.Belongings()
    )
    var confidentiality by vm.data.stateOf(
        PatientInformationDto::confidentiality,
        PatientInformationDto.Confidentiality()
    )

    fun saveAndReturn() {
        vm.save()
        onBackClicked()
    }

    if (arrivalTime == null) {
        arrivalTime = Clock.System.now()
    }

    DetailPageWrapper(
        title = stringResource(id = R.string.patientInfo),
        titleColor = Colors.arrivalPrimary,
        onBackClicked = ::saveAndReturn,
        onMenuClicked = onMenuClicked
    ) {
        Column {

            TextField(value = belongings.toString(), onValueChange = {},
                textStyle = TextStyle(fontFamily = FontFamily.Monospace)
            )

            TitledSection(title = "Ankomsttid") {
                Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                    DateField(date = arrivalTime.toString())
                    ArrivalTime(
                        setTimestamp = { time -> time?.let { arrivalTime?.setTime(it) } },
                        time = arrivalTime?.getTime() ?: Clock.System.now().getTime()
                    )
                    EssNumber(
                        setEssNumber = { ess = mutableSetOf(it.toInt()) },
                        essNumber = ess.firstOrNull().toString()
                    )
                }

            }

            TitledSection(title = stringResource(id = R.string.belongins)) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row {
                        LabeledCheckbox(
                            label = "Finns inga på akutmottagningen",
                            checked = belongings.noBelongingsAtWard,
                            onCheckedChange = { belongings = belongings.copy(noBelongingsAtWard = it) }
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                        LabeledCheckbox(
                            label = "Lämnat på akutmottagningen",
                            checked = belongings.belongingsAtWard,
                            onCheckedChange = { belongings = belongings.copy(belongingsAtWard = it) }
                        )
                        TitledTextField(
                            title = "Skåpsnummer",
                            textValue = belongings.lockerNumber ?: "",
                            onChangeText = { belongings = belongings.copy(lockerNumber = it) },
                            isEnabled = belongings.belongingsAtWard
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                        LabeledCheckbox(
                            label = "Lämnat till anhörig/signering",
                            checked = belongings.belongingsGivenToRelatedPerson,
                            onCheckedChange = { belongings = belongings.copy(belongingsGivenToRelatedPerson = it) }
                        )
                        TitledTextField(
                            title = "Signering",
                            textValue = belongings.belongingsGivenSignature ?: "",
                            onChangeText = { belongings = belongings.copy(belongingsGivenSignature = it) },
                            isEnabled = belongings.belongingsGivenToRelatedPerson
                        )
                    }
                }
            }

            TitledSection(title = stringResource(id = R.string.secrecy)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {

                    EnumRadioButtonsHorizontal(
                        choices = YesNoQuestion.labels.keys.toTypedArray(),
                        labels = YesNoQuestion.labels,
                        currentChoice = confidentiality.yesNoQuestion,
                        onSelection = { confidentiality = confidentiality.copy(yesNoQuestion = it) }
                    )
                    TitledTextField(
                        title = stringResource(id = R.string.reservation),
                        textValue = confidentiality.reservations ?: "",
                        onChangeText = { confidentiality = confidentiality.copy(reservations = it) }
                    )

                }
            }
/*
            TitledSection(title = stringResource(id = R.string.identity)) {
                Identity(
                    value = patientInfoViewModel.arrivalStates.confirmedIdentity,
                    onChange = { patientInfoViewModel.arrivalStates.confirmedIdentity = it }
                )
            }

            TitledSection(title = stringResource(id = R.string.samsa)) {
                Samsa(
                    value = patientInfoViewModel.arrivalStates.samsa,
                    onChange = { patientInfoViewModel.arrivalStates.samsa = it }
                )
            }

            TitledSection(title = stringResource(id = R.string.relative)) {
                Relative(
                    setRelativeName = { patientInfoViewModel.arrivalStates.relativeName = it },
                    setRelativePhoneNumber = {
                        patientInfoViewModel.arrivalStates.relativePhoneNumber = it
                    },
                    relativeName = patientInfoViewModel.arrivalStates.relativeName,
                    relativePhoneNumber = patientInfoViewModel.arrivalStates.relativePhoneNumber
                )
            }

            TitledSection(title = stringResource(id = R.string.childrenInHouseHold)) {
                ChildrenInHouseHold(
                    onChange = { patientInfoViewModel.arrivalStates.children = it.toMutableList() },
                    values = patientInfoViewModel.arrivalStates.children,
                    onConcernReportChange = { patientInfoViewModel.arrivalStates.concernReport = it },
                    concernReport = patientInfoViewModel.arrivalStates.concernReport
                )
            }
 */
        }
    }
}
