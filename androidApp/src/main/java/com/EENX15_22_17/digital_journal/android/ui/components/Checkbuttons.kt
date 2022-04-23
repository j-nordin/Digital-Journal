package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.checkBoxColor
import com.EENX15_22_17.digital_journal.android.ui.theme.colorCheckBoxBeta

@Composable
fun <E : Enum<*>> EnumCheckBox(
    choices: Array<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    selection: Set<E>,
    labels: Map<E, String>
) {

    val currentSelection: MutableSet<E> = selection.toMutableSet()
    Column {
        choices.forEach { choice ->
            var isChecked by rememberSaveable { mutableStateOf(choice in selection) }
            Text(text = labels[choice] ?: choice.name, textAlign = TextAlign.Center)
            Box(
                modifier = Modifier.background(colorCheckBoxBeta, CircleShape)
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
                        onSelectionChanged(selection.toSet())
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
    Row(modifier = Modifier.padding(2.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        EnumCheckBox(
            choices = choices,
            onSelectionChanged = onSelectionChanged,
            selection = currentSelected,
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
            selection = currentSelected,
            labels = labels
        )
    }
}


@Composable
fun <E : Enum<*>> EnumCheckBoxLazyGrid(
    choices: Array<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    currentSelected: Set<E>,
    labels: Map<E, String>,
    gridLayout: GridCells,
    circleBgColor: Color = checkBoxColor,
    textFontSize: Int = 20,
    isHorizontal: Boolean = false
) {
    val currentSelection: MutableSet<E> = currentSelected.toMutableSet()
    if (isHorizontal) {
        LazyHorizontalGrid(
            rows = gridLayout,
            content = {
                items(choices.size) { index ->
                    var isChecked by rememberSaveable { mutableStateOf(choices[index] in currentSelection) }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Box(
                            modifier = Modifier.background(colorCheckBoxBeta, CircleShape)
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { checked ->
                                    isChecked = checked
                                    when (checked) {
                                        false -> currentSelection.remove(choices[index])
                                        true -> currentSelection.add(choices[index])
                                    }
                                    onSelectionChanged(currentSelection.toSet())
                                }
                            )
                        }
                        Text(
                            text = labels[choices[index]] ?: choices[index].name,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(start = 8.dp),
                            fontSize = textFontSize.sp
                        )
                    }
                }

            }
        )
    } else {
        LazyVerticalGrid(
            columns = gridLayout,
            content = {
                items(choices.size) { index ->
                    var isChecked by rememberSaveable { mutableStateOf(choices[index] in currentSelection) }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Box(
                            modifier = Modifier.background(colorCheckBoxBeta, CircleShape)
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { checked ->
                                    isChecked = checked
                                    when (checked) {
                                        false -> currentSelection.remove(choices[index])
                                        true -> currentSelection.add(choices[index])
                                    }
                                    onSelectionChanged(currentSelection.toSet())
                                }
                            )
                        }
                        Text(
                            text = labels[choices[index]] ?: choices[index].name,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(start = 8.dp),
                            fontSize = textFontSize.sp
                        )
                    }
                }
            }
        )
    }
}


@Composable
fun LabeledCheckbox(
    label: String,
    checked: Boolean,
    onCheckedChange: (isChecked: Boolean) -> Unit
) {
    var isChecked by rememberSaveable { mutableStateOf(checked) }
    Row {
        Box(
            modifier = Modifier.background(colorCheckBoxBeta, CircleShape)
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    onCheckedChange(isChecked)
                }
            )
        }
        Text(
            modifier = Modifier.padding(start = 4.dp, top = 14.dp),
            text = label,
            textAlign = TextAlign.Center
        )
    }
}

