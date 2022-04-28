package com.EENX15_22_17.digital_journal.android.screens.journal.arrival.patientInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSection
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors


@Composable
fun PatientInfoScreen(
    patientInfoViewModel: PatientInfoViewModel = PatientInfoViewModel(),
    journalId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {

    DetailPageWrapper(
        title = stringResource(id = R.string.patientInfo),
        titleColor = Colors.arrivalPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Column {
            TitledSection(title = "Ankomsttid") {
                Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                    DateField(date = patientInfoViewModel.getTimestamp())
                    ArrivalTime(
                        setTimestamp = { patientInfoViewModel.arrivalStates.timestamp = it },
                        timeStamp = patientInfoViewModel.arrivalStates.timestamp
                    )
                    EssNumber(
                        setEssNumber = { patientInfoViewModel.arrivalStates.ess = it },
                        essNumber = patientInfoViewModel.arrivalStates.ess
                    )
                }

            }

            TitledSection(title = stringResource(id = R.string.belongins)) {
                BelongingsContent(
                    noBelongings = false,
                    onHospital = false,
                    byRelative = false,
                    lockNumber = patientInfoViewModel.arrivalStates.lockNumber,
                    onLockNumberChange = { patientInfoViewModel.arrivalStates.lockNumber = it },
                    signature = patientInfoViewModel.arrivalStates.signature,
                    onSignatureChange = { patientInfoViewModel.arrivalStates.signature = it }
                )

            }

            TitledSection(title = stringResource(id = R.string.secrecy)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Secrecy(
                        value = patientInfoViewModel.arrivalStates.secrecy,
                        onChange = { patientInfoViewModel.arrivalStates.secrecy = it }
                    )

                    SecrecyReservation(
                        setSecrecyReservation = { patientInfoViewModel.arrivalStates.reservation = it },
                        reservation = patientInfoViewModel.arrivalStates.reservation
                    )
                }
            }

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
        }
    }
}
