package com.EENX15_22_17.digital_journal.android.ui.contactcause

import com.EENX15_22_17.digital_journal.android.screens.triage.contactreason.TextFieldContent


fun ContactCauseList(): List<TextFieldContent> {
    return listOf(
        TextFieldContent(
            "Situation",
            "Information kopplat till situation",
        ),
        TextFieldContent(
            "Bakgrund",
            "Information kopplat till bakgrund",
        ),
        TextFieldContent(
            "Aktuellt tillstånd",
            "Information kopplat till aktuellt tillstånd",
        ),
        TextFieldContent(
            "Rekommendation",
            "Information kopplat till rekommendation",
        ),
        TextFieldContent(
            "Övrigt",
            "Övrig information",
        )

    )
}