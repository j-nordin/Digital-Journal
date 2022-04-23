package com.EENX15_22_17.digital_journal.android.ui.theme

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val DigitalJournalShapes = Shapes(
    small = RoundedCornerShape(2.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(8.dp)
)

val checkboxBackgroundShape = RoundedCornerShape(CornerSize(4.dp))
// This is not used as it seems not possible to change the box part of checkboxes.
val checkboxBoxSize = 26.dp
