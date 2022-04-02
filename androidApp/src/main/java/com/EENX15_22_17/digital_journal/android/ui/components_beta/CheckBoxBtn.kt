package com.EENX15_22_17.digital_journal.android.ui.components_beta

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorCheckBoxBeta

@Composable
fun CheckBoxBtn(value : Boolean, onValueChange : ((Boolean) -> Unit)? ) {
    Box(modifier = Modifier
        .padding(2.dp)
        .clip(shape = CircleShape)
        .background(colorCheckBoxBeta)
    ) {
        Checkbox(checked = value, onCheckedChange = onValueChange)
    }

}