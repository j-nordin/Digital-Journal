package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.borderColor

@Composable
fun ArrivalPage(
    arrivalViewModel: ArrivalViewModel = ArrivalViewModel(),
    visitId: String,
    navBack: () -> Unit
) {
    val rowModifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp, horizontal = 2.dp)
        .border(
            border = BorderStroke(
                2.dp,
                borderColor
            ),
            shape = RoundedCornerShape(8.dp)
        )
        .padding(horizontal = 16.dp, vertical = 12.dp)

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Ankomst sidan för patient: $visitId")
        Button(onClick = navBack) {
            Text(text = "Gå tillbaka")
        }
        Row(
            modifier = rowModifier,
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
            modifier = rowModifier,
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
        Row {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(vertical = 6.dp, horizontal = 2.dp)
                    .border(
                        border = BorderStroke(
                            2.dp,
                            borderColor
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Identity(
                    value = arrivalViewModel.arrivalStates.confirmedIdentity,
                    onChange = { arrivalViewModel.arrivalStates.confirmedIdentity = it }
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 2.dp)
                    .border(
                        border = BorderStroke(
                            2.dp,
                            borderColor
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Samsa(
                    value = arrivalViewModel.arrivalStates.samsa,
                    onChange = {
                        arrivalViewModel.arrivalStates.samsa = it
                        println(arrivalViewModel.arrivalStates.samsa.name)
                    }
                )
            }
        }
        Row(
            modifier = rowModifier,
        ) {
            Relative(
                setRelativeName = { arrivalViewModel.arrivalStates.relativeName = it },
                setRelativePhoneNumber = {
                    arrivalViewModel.arrivalStates.relativePhoneNumber = it
                },
                relativeName = arrivalViewModel.arrivalStates.relativeName,
                relativePhoneNumber = arrivalViewModel.arrivalStates.relativePhoneNumber
            )
        }
        Row(
            modifier = rowModifier
        ) {
            ChildrenInHouseHold(
                onChange = { arrivalViewModel.arrivalStates.children = it.toMutableList() },
                values = arrivalViewModel.arrivalStates.children,
                onConcernReportChange = { arrivalViewModel.arrivalStates.concernReport = it },
                concernReport = arrivalViewModel.arrivalStates.concernReport
            )
        }
        Row {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(vertical = 6.dp, horizontal = 2.dp)
                    .border(
                        border = BorderStroke(
                            2.dp,
                            borderColor
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                ArrivalType(
                    choices = arrivalMethods.keys.toTypedArray(),
                    onChange = { arrivalViewModel.arrivalStates.arrivalMethod = it},
                    currentSelected = arrivalViewModel.arrivalStates.arrivalMethod,
                    labels = arrivalMethods
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 2.dp)
                    .border(
                        border = BorderStroke(
                            2.dp,
                            borderColor
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Laws(
                    choices = laws.keys.toTypedArray(),
                    onChange = { arrivalViewModel.arrivalStates.law = it},
                    currentSelected = arrivalViewModel.arrivalStates.law,
                    labels = laws
                )
            }
        }
    }
}