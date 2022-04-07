package com.EENX15_22_17.digital_journal.android.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

/*TODO: Refactor to not use top level colors */
val danger = Color(0xFFCD9A50)
val colorIcon = Color(0xFF989383)
val rettsLineOneNavigationCard = Color(0xFFF4D4E0)
val rettsLineTwoNavigationCard = Color(0xFFC2E0E2)
val rettsLineFourNavigationCard = Color(0xFFE1CCE3)
val colorTextFieldGray = Color(0xFFBDBDBD)
val colorTextGray = Color(0xFFA2A2A2)
val colorTextBlackLight = Color(0xFF2F2F2F)
val checkBoxColor = Color(0xFF989383)
val borderColor = Color(0xFF1F1F1F)



/* TODO: Set these theme colors */
val primary = Color(0xFF295BC0)

val secondary = Color(0x92F5AB72)

val error = Color(0xFFBA1B1B)

val onBackgound = Color(0xFF191C1D)

val background = Color(0xFFFBFDFD)

fun Color.brighter(fraction: Float) = lerp(this, Color.White, fraction)

object Colors {
    val arrivalPrimary = Color(0xFFC64072)
    val arrivalBackground = arrivalPrimary.brighter(0.7f)
    val triagePrimary = Color(0xFF3D8085)
    val triageBackground = arrivalPrimary.brighter(0.7f)
    val treatmentPrimary = Color(0xFF87618A)
    val treatmentBackground = arrivalPrimary.brighter(0.7f)
}


val colorCheckBoxBeta = Color(0xFFE8F4FE)
val summarySuicideCard = Color(0xFF2196F3)