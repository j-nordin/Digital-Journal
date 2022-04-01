package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalMethod
import com.EENX15_22_17.digital_journal.android.ui.theme.checkBoxColor

@Composable
fun CheckButton(
    isEnabled: Boolean = true,
    handleSelected: (isChecked: Boolean) -> Unit = { }
) {
    var checked by remember { mutableStateOf(false) }
    Checkbox(
        checked = checked,
        onCheckedChange = { checked = !checked; handleSelected(checked) },
        modifier = Modifier
            .size(50.dp)
            .border(BorderStroke(2.dp, checkBoxColor), CircleShape)
            .background(checkBoxColor, CircleShape),
        enabled = isEnabled
    )
}

@Composable
fun CheckButtonWithText(
    isEnabled: Boolean = true,
    text: String,
    handleSelected: (isChecked: Boolean) -> Unit = { }
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CheckButton(
            isEnabled = isEnabled,
            handleSelected = handleSelected
        )
        Text(text = text)
    }
}


@Composable
fun <E : Enum<*>> EnumCheckBox(
    choices: Array<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    currentSelected: MutableSet<E>
) {
    val selection: MutableSet<E> = rememberSaveable { currentSelected }

    Column {
        choices.forEach { choice  ->
            Box {
                Checkbox(
                    checked = (choice in selection.toSet()),
                    onCheckedChange = {
                        println(it)
                        when(it) {
                            false -> selection.remove(choice)
                            true -> selection.add(choice)
                        }
                        onSelectionChanged(selection.toSet())
                    }
                )

                Text(text = choice.name)
            }
        }
    }


}

