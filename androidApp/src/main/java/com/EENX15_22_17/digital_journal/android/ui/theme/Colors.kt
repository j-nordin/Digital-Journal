package com.EENX15_22_17.digital_journal.android.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import se.predicare.journal.screens.JournalSection
import se.predicare.retts.RettsColor

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
    val eventsPrimary = Color(0xFF78907A)
    val eventsBackground = arrivalPrimary.brighter(0.7f)
    val treatmentPrimary = Color(0xFF87618A)
    val treatmentBackground = arrivalPrimary.brighter(0.7f)

    val journalSectionColors = mapOf(
        JournalSection.ARRIVAL to arrivalPrimary,
        JournalSection.TRIAGE to triagePrimary,
        JournalSection.EVENTS to eventsPrimary,
        JournalSection.INTERIM_JOURNAL to treatmentPrimary
    )

    val riskLevel1 = Color(0xFFE93830); // red
    val riskLevel2 = Color(0xFFF17B14); // orange
    val riskLevel3 = Color(0xFFFDD701); // yellow
    val riskLevel4 = Color(0xFF25A02C); // green
    val riskLevel5 = Color(0xFF337AB7); // blue

    fun RettsColor.getAndroidColor(): Color = when(this) {
        RettsColor.RED -> riskLevel1
        RettsColor.ORANGE -> riskLevel2
        RettsColor.YELLOW -> riskLevel3
        RettsColor.GREEN -> riskLevel4
        RettsColor.BLUE -> riskLevel5
    }
}


val colorCheckBoxBeta = Color(0xFFF5F5F5)
val summarySuicideCard = Color(0xFF2196F3)