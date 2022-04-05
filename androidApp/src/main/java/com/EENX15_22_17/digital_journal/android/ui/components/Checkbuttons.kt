package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.primaryColor

@Composable
fun <E : Enum<*>> EnumCheckBox(
    choices: Array<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    currentSelected: MutableSet<E>,
    labels: Map<E, String>
) {
    choices.forEach { choice ->
        var isChecked by rememberSaveable { mutableStateOf(choice in currentSelected) }
        Text(text = labels[choice] ?: choice.name, textAlign = TextAlign.Center)
        Box(
            modifier = Modifier.background(primaryColor, CircleShape)
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = when (it) {
                        false -> {
                            currentSelected.remove(choice)
                            false
                        }
                        true -> {
                            currentSelected.add(choice)
                            true
                        }
                    }
                    onSelectionChanged(currentSelected.toSet())
                }
            )
        }
    }
}


@Composable
fun <E : Enum<*>> EnumCheckBoxHorizontal(
    choices: Array<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    currentSelected: MutableSet<E>,
    labels: Map<E, String>
) {
    Row(modifier = Modifier.padding(2.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        EnumCheckBox(
            choices = choices,
            onSelectionChanged = onSelectionChanged,
            currentSelected = currentSelected,
            labels = labels
        )
    }
}

@Composable
fun <E : Enum<*>> EnumCheckBoxVertical(
    choices: Array<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    currentSelected: MutableSet<E>,
    labels: Map<E, String>
) {
    Column(modifier = Modifier.padding(2.dp)) {
        EnumCheckBox(
            choices = choices,
            onSelectionChanged = onSelectionChanged,
            currentSelected = currentSelected,
            labels = labels
        )
    }
}

