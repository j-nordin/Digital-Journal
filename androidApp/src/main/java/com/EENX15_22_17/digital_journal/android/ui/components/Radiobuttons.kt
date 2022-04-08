package com.EENX15_22_17.digital_journal.android.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.checkBoxColor


@Composable
fun <E : Enum<*>> EnumRadioButtonsHorizontal(
    choices: Array<E>,
    labels: Map<E, String>,
    currentChoice: E,
    onSelection: (choice: E) -> Unit
) {
    Row {
        EnumRadioButtons(
            choices = choices,
            labels = labels,
            currentChoice = currentChoice,
            onSelection = onSelection
        )
    }
}

@Composable
fun <E : Enum<*>> EnumRadioButtonsVertical(
    choices: Array<E>,
    labels: Map<E, String>,
    currentChoice: E,
    onSelection: (choice: E) -> Unit
) {
    Column {
        EnumRadioButtons(
            choices = choices,
            labels = labels,
            currentChoice = currentChoice,
            onSelection = onSelection
        )
    }
}


@Composable
fun <E : Enum<*>> EnumRadioButtons(
    choices: Array<E>,
    labels: Map<E, String>,
    currentChoice: E,
    onSelection: (choice: E) -> Unit
) {
    var selection by rememberSaveable { mutableStateOf(currentChoice) }

    choices.forEach { choice ->
        Box(
            Modifier
                .clickable {
                    selection = choice
                    onSelection(choice)
                }
                .padding(horizontal = 12.dp)
                .background(checkBoxColor, CircleShape)
        ) {
            RadioButton(
                selected = (choice == selection),
                modifier = Modifier.padding(all = Dp(value = 8F)),
                onClick = {
                    selection = choice
                    onSelection(choice)
                }
            )
            Text(
                text = labels[choice] ?: choice.name,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}
