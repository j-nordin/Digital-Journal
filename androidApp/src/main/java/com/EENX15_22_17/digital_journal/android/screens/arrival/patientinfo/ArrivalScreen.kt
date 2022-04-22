package com.EENX15_22_17.digital_journal.android.screens.arrival.patientinfo

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
fun ArrivalPage(
    arrivalViewModel: ArrivalViewModel = ArrivalViewModel(),
    visitId: String,
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
                    DateField(date = arrivalViewModel.getTimestamp())
                    ArrivalTime(
                        setTimestamp = { arrivalViewModel.arrivalStates.timestamp = it },
                        timeStamp = arrivalViewModel.arrivalStates.timestamp
                    )
                    EssNumber(
                        setEssNumber = { arrivalViewModel.arrivalStates.ess = it },
                        essNumber = arrivalViewModel.arrivalStates.ess
                    )
                }

            }

            TitledSection(title = stringResource(id = R.string.belongins)) {
                BelongingsContent(
                    noBelongings = false,
                    onHospital = false,
                    byRelative = false,
                    lockNumber = arrivalViewModel.arrivalStates.lockNumber,
                    onLockNumberChange = { arrivalViewModel.arrivalStates.lockNumber = it },
                    signature = arrivalViewModel.arrivalStates.signature,
                    onSignatureChange = { arrivalViewModel.arrivalStates.signature = it }
                )

            }

            TitledSection(title = stringResource(id = R.string.secrecy)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Secrecy(
                        value = arrivalViewModel.arrivalStates.secrecy,
                        onChange = { arrivalViewModel.arrivalStates.secrecy = it }
                    )

                    SecrecyReservation(
                        setSecrecyReservation = { arrivalViewModel.arrivalStates.reservation = it },
                        reservation = arrivalViewModel.arrivalStates.reservation
                    )
                }
            }

            TitledSection(title = stringResource(id = R.string.identity)) {
                Identity(
                    value = arrivalViewModel.arrivalStates.confirmedIdentity,
                    onChange = { arrivalViewModel.arrivalStates.confirmedIdentity = it }
                )
            }

            TitledSection(title = stringResource(id = R.string.samsa)) {
                Samsa(
                    value = arrivalViewModel.arrivalStates.samsa,
                    onChange = { arrivalViewModel.arrivalStates.samsa = it }
                )
            }

            TitledSection(title = stringResource(id = R.string.relative)) {
                Relative(
                    setRelativeName = { arrivalViewModel.arrivalStates.relativeName = it },
                    setRelativePhoneNumber = {
                        arrivalViewModel.arrivalStates.relativePhoneNumber = it
                    },
                    relativeName = arrivalViewModel.arrivalStates.relativeName,
                    relativePhoneNumber = arrivalViewModel.arrivalStates.relativePhoneNumber
                )
            }

            TitledSection(title = stringResource(id = R.string.childrenInHouseHold)) {
                ChildrenInHouseHold(
                    onChange = { arrivalViewModel.arrivalStates.children = it.toMutableList() },
                    values = arrivalViewModel.arrivalStates.children,
                    onConcernReportChange = { arrivalViewModel.arrivalStates.concernReport = it },
                    concernReport = arrivalViewModel.arrivalStates.concernReport
                )
            }
        }
    }
}
