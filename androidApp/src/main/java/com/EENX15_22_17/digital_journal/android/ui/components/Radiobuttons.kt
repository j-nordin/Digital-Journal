package com.EENX15_22_17.digital_journal.android.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorCheckBoxBeta


@Composable
fun <E : Enum<*>> EnumRadioButtonsHorizontal(
    choices: Array<E>,
    labels: Map<E, String>,
    currentChoice: E,
    onSelection: (choice: E) -> Unit,
    isEnabled: Boolean = true
) {
    Row {
        EnumRadioButtons(
            choices = choices,
            labels = labels,
            currentChoice = currentChoice,
            onSelection = onSelection,
            isEnabled = isEnabled
        )
    }
}

@Composable
fun <E : Enum<*>> EnumRadioButtonsVertical(
    choices: Array<E>,
    labels: Map<E, String>,
    currentChoice: E,
    onSelection: (choice: E) -> Unit,
    isEnabled: Boolean = true
) {
    Column {
        EnumRadioButtons(
            choices = choices,
            labels = labels,
            currentChoice = currentChoice,
            onSelection = onSelection,
            isEnabled = isEnabled
        )
    }
}


@Composable
fun <E : Enum<*>> EnumRadioButtons(
    choices: Array<E>,
    labels: Map<E, String>,
    currentChoice: E,
    onSelection: (choice: E) -> Unit,
    isEnabled: Boolean = true
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

        ) {
            RadioButton(
                selected = (choice == selection),
                modifier = Modifier
                    .padding(4.dp)
                    .background(colorCheckBoxBeta, CircleShape),
                onClick = {
                    selection = choice
                    onSelection(choice)
                },
                enabled = isEnabled
            )
            Text(
                text = labels[choice] ?: choice.name,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

@Composable
fun <E : Enum<*>> EnumRadioButtonWithTextField(
    choices: Array<E>,
    labels: Map<E, String>,
    currentChoice: E,
    onSelection: (choice: E) -> Unit,
    isEnabled: Boolean = true,
    textValues: Map<E, String>,
    onChangeTextValue: (choice: E, textValue: String) -> Unit,
    title: Map<E, String>,
    hasTextfield: Map<E, Boolean>
) {
    var selection by rememberSaveable { mutableStateOf(currentChoice) }
    Column {
        choices.forEach { choice ->
            Row(modifier = Modifier.padding(horizontal = 10.dp)) {
                Box(
                    Modifier
                        .clickable {
                            selection = choice
                            onSelection(choice)
                        }
                        .padding(horizontal = 12.dp)

                ) {
                    RadioButton(
                        selected = (choice == selection),
                        modifier = Modifier
                            .padding(4.dp)
                            .background(colorCheckBoxBeta, CircleShape),
                        onClick = {
                            selection = choice
                            onSelection(choice)
                        },
                        enabled = isEnabled
                    )
                    Text(
                        text = labels[choice] ?: choice.name,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                if (hasTextfield[choice] == true) {
                    TitledTextField(
                        title = title[choice] ?: "",
                        onChangeText = { onChangeTextValue(choice, it) },
                        textValue = textValues[choice] ?: "",
                        isEnabled = choice == selection
                    )
                }
            }
        }

    }
}
