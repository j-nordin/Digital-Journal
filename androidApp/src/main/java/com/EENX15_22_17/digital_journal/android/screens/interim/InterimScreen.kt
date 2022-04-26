package com.EENX15_22_17.digital_journal.android.screens.interim

import androidx.compose.foundation.layout.Column
import androidx.compose.material.RadioButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoLabels
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.*
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import se.predicare.journal.data.EnumChoiceWithIndividualNotes
import se.predicare.journal.screens.InterimJournalDto

@Composable
fun InterimPage(
    interimViewModel: InterimViewModel,
    visitId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.interimJournal),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Column {
            TitledSection(title = stringResource(id = R.string.patientDecision)) {
                var textFieldEnabled by rememberSaveable { mutableStateOf(interimViewModel.interimStates.patientAction.choice)}
                EnumRadioButtonWithTextField(
                    choices = patientDecision.keys.toTypedArray(),
                    labels = patientDecision,
                    currentChoice = interimViewModel.interimStates.patientAction.choice,
                    onSelection = {
                    },
                    onChangeTextValue = {},
                    title = patientDecisionTitles,
                    textValues = mapOf(),
                    hasTextfield = patientDecisionTextfields,
                )
            }
        }
    }
}

@Composable
fun PatientDecisionContent(

) {


}
