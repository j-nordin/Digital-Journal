package com.EENX15_22_17.digital_journal.android.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason.RettsClickableData
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason.RettsSymtomChip
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.kodein.di.compose.androidContextDI
import org.kodein.di.instance
import se.predicare.journal.screens.ContactReasonDto

val json = Json {
    prettyPrint = true
}

@Composable
fun ContactReasonScreen(
    journalId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit,
) {
    val di = androidContextDI()

    val vm: ContactReasonViewModel by di.instance(arg = journalId)

    var jsonModel by rememberSaveable {
        mutableStateOf(json.encodeToString(vm.data.model))
    }

    vm.update()

    var situation by vm.data.stateOf(ContactReasonDto::sbar, ContactReasonDto.SBAR::situation)
    var background by vm.data.stateOf(ContactReasonDto::sbar, ContactReasonDto.SBAR::background)
    var assessment by vm.data.stateOf(ContactReasonDto::sbar, ContactReasonDto.SBAR::assessment)
    var recommendation by vm.data.stateOf(ContactReasonDto::sbar, ContactReasonDto.SBAR::recommendation)
    var otherNotes by vm.data.stateOf(ContactReasonDto::otherNotes)
    var patientExpectations by vm.data.stateOf(ContactReasonDto::patientExpectations)

    DetailPageWrapper(
        title = stringResource(id = R.string.contactReason),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {

                Text(text = jsonModel, fontFamily = FontFamily.Monospace)

                Button(onClick = {
                    jsonModel = json.encodeToString(vm.data.model)
                }) {
                    Text("Show current JSON")
                }

                Button(onClick = { vm.update() }) {
                    Text("Load from backend")
                }
                Button(onClick = { vm.save() }) {
                    Text("Save to backend")
                }

                TitledTextField(
                    title = "Situation",
                    textValue = situation ?: "",
                    onChangeText = { situation = it }, //TODO: Implement View Model for Contact Cause
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                Text(vm.data.otherNotes?:"")

                TitledTextField(
                    title = "Bakgrund",
                    textValue = background ?: "",
                    onChangeText = { background = it },  //TODO: Implement View Model for Contact Cause
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Aktuellt tillstånd",
                    textValue = assessment ?: "",
                    onChangeText = { assessment = it },  //TODO: Implement View Model for Contact Cause
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Rekommendation",
                    textValue = recommendation ?: "",
                    onChangeText = { recommendation = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(modifier = Modifier.fillMaxWidth(0.50f)) {
                        TitledTextField(
                            title = "Övrigt",
                            onChangeText = { otherNotes = it },
                            textValue = otherNotes ?: "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(width = 200.dp, height = 100.dp)
                        )
                    }
                    Column(Modifier.padding(start = 20.dp)) {
                        TitledTextField(
                            title = "Förväntan på besöket",
                            textValue = patientExpectations ?: "",
                            onChangeText = { patientExpectations = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(width = 200.dp, height = 100.dp)
                        )
                    }
                }


                val scrollState = rememberScrollState()
                Box(
                    modifier = Modifier
                        .size(width = 600.dp, height = 250.dp)
                        .verticalScroll(scrollState)
                ) {
                    Column(
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        RettsSymtomChip(
                            item = RettsClickableData(
                                data = "Nedsatt koncentration",
                                color = Color.Green
                            ), onClick = {}) //TODO: Implement View Model for Retts Clickable Items
                        RettsSymtomChip(
                            item = RettsClickableData(
                                data = "Psykomotorisk oro (oroligt beteende, rastlöshet)",
                                color = Color.Yellow
                            ), onClick = {}) //TODO: Implement View Model for Retts Clickable Items
                        RettsSymtomChip(
                            item = RettsClickableData(
                                data = "Social isolering",
                                color = Color.Yellow
                            ), onClick = {}) //TODO: Implement View Model for Retts Clickable Items
                    }
                }

            }
        }
    }
}