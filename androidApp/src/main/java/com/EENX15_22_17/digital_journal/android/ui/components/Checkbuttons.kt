package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.background
import com.EENX15_22_17.digital_journal.android.ui.theme.checkBoxColor

@Composable
fun <E : Enum<*>> EnumCheckBox(
    choices: Array<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    currentSelected: Set<E>,
    labels: Map<E, String>
) {

    val currentSelection: MutableSet<E> = currentSelected.toMutableSet()
    Column {
        choices.forEach { choice ->
            var isChecked by rememberSaveable { mutableStateOf(choice in currentSelected) }
            Text(text = labels[choice] ?: choice.name, textAlign = TextAlign.Center)
            Box(
                modifier = Modifier.background(MaterialTheme.colors.secondary, CircleShape)
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = when (it) {
                            false -> {
                                currentSelection.remove(choice)
                                false
                            }
                            true -> {
                                currentSelection.add(choice)
                                true
                            }
                        }
                        onSelectionChanged(currentSelected.toSet())
                    }
                )
            }
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
    Row(modifier = Modifier.padding(2.dp)) {
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


@Composable
fun <E : Enum<*>> EnumCheckBoxLazyGrid(
    choices: Array<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    currentSelected: Set<E>,
    labels: Map<E, String>
) {
    val currentSelection: MutableSet<E> = currentSelected.toMutableSet()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(300.dp),
        content = {
            items(choices.size) { index ->
                var isChecked by rememberSaveable { mutableStateOf(choices[index] in currentSelection) }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(4.dp)
                ) {
                    Box(
                        modifier = Modifier.background(checkBoxColor, CircleShape)
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = {
                                isChecked = when (it) {
                                    false -> {
                                        currentSelection.remove(choices[index])
                                        false
                                    }
                                    true -> {
                                        currentSelection.add(choices[index])
                                        true
                                    }
                                }
                                onSelectionChanged(currentSelection.toSet())
                            }
                        )
                    }
                    Text(
                        text = labels[choices[index]] ?: choices[index].name,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.padding(start = 4.dp),
                        fontSize = 20.sp
                    )
                }


            }
        }
    )
}

