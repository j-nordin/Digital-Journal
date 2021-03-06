package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.modifyIf
import com.EENX15_22_17.digital_journal.android.ui.theme.TextStyles
import com.EENX15_22_17.digital_journal.android.ui.theme.checkboxBackgroundShape
import com.EENX15_22_17.digital_journal.android.ui.theme.checkboxBoxBackgroundSize
import com.EENX15_22_17.digital_journal.android.ui.theme.colorCheckBoxBeta


@Composable
fun <E : Enum<*>> EnumCheckboxesHorizontal(
    choices: Array<E>,
    labels: Map<E, String>,
    selection: MutableSet<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit
) = EnumCheckboxesLazyGrid(
    choices = choices,
    labels = labels,
    selection = selection,
    onSelectionChanged = onSelectionChanged,
    gridLayout = GridCells.Fixed(1),
    isHorizontal = true
)

@Composable
fun <E : Enum<*>> EnumCheckboxesVertical(
    choices: Array<E>,
    labels: Map<E, String>,
    selection: MutableSet<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit
) = EnumCheckboxesLazyGrid(
    choices = choices,
    labels = labels,
    selection = selection,
    onSelectionChanged = onSelectionChanged,
    gridLayout = GridCells.Fixed(1),
    isHorizontal = false
)


@Composable
fun <E : Enum<*>> EnumCheckboxesLazyGrid(
    choices: Array<E>,
    labels: Map<E, String>,
    selection: Set<E>,
    onSelectionChanged: (selected: Set<E>) -> Unit,
    gridLayout: GridCells,
    isHorizontal: Boolean = false,
    checkboxSpacing: Dp = 8.dp,
    isEnabled: Boolean = true
) {
    val currentSelection: MutableSet<E> = selection.toMutableSet()
    val content: LazyGridScope.() -> Unit = {
        items(choices.size) { index ->
            var isChecked by rememberSaveable { mutableStateOf(choices[index] in currentSelection) }
            LabeledCheckbox(
                label = labels[choices[index]] ?: choices[index].name,
                checked = isChecked,
                onCheckedChange = { checked ->
                    isChecked = checked
                    when (checked) {
                        false -> currentSelection.remove(choices[index])
                        true -> currentSelection.add(choices[index])
                    }
                    onSelectionChanged(currentSelection.toSet())
                },
                isEnabled = isEnabled
            )
        }
    }
    val spacing = Arrangement.spacedBy(checkboxSpacing)
    when {
        isHorizontal -> LazyHorizontalGrid(rows = gridLayout, content = content, verticalArrangement = spacing, horizontalArrangement = spacing)
        else -> LazyVerticalGrid(columns = gridLayout, content = content, verticalArrangement = spacing, horizontalArrangement = spacing)
    }
}

@Composable
fun LabeledCheckbox(
    label: String,
    checked: Boolean,
    clickableText: Boolean = false,
    onCheckedChange: (isChecked: Boolean) -> Unit,
    isEnabled: Boolean = true
) {
    var isChecked by rememberSaveable { mutableStateOf(checked) }

    fun changeState(newState: Boolean? = null) {
        isChecked = newState ?: !isChecked
        onCheckedChange(isChecked)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(contentAlignment = Alignment.Center) {
            Box(Modifier
                .size(checkboxBoxBackgroundSize)
                .background(colorCheckBoxBeta, checkboxBackgroundShape)
            )
            Checkbox(
                checked = isChecked,
                onCheckedChange = ::changeState,
                enabled = isEnabled
            )
        }
        Text(
            modifier = Modifier
                .padding(start = 8.dp)
                .modifyIf(clickableText, Modifier.clickable { changeState() }),
            text = label,
            style = TextStyles.checkboxLabel,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
@Preview
private fun LabeledCheckboxPreview() = LabeledCheckbox(
    label = "Long checkbox label that could potentially span multiple lines in case there is not a wide enough container for it",
    checked = true,
    onCheckedChange = {}
)