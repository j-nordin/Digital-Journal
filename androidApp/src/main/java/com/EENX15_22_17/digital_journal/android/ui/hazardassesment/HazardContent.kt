package com.EENX15_22_17.digital_journal.android.ui.hazardassesment

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField

@Composable
fun ActionTakenTextField(
    setActionTaken: (actionTaken: String) -> Unit,
    actionTaken: String,
) {
    TitledTextField(
        modifier = Modifier
            .width(600.dp)
            .height(250.dp),
        title = stringResource(id = R.string.hazardActionTaken),
        onChangeText = setActionTaken,
        textValue = actionTaken
    )
}

