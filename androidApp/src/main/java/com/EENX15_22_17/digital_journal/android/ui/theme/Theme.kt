package com.EENX15_22_17.digital_journal.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val themeColors = lightColors(
    primary = Blue40,
    onPrimary = Color.White,
    secondary = DarkBlue40,
    onSecondary = Color.White,
    error = Red40,
    onError = Color.White,
    background = Grey99,
    onBackground = Grey10,
    surface = Grey99,
    onSurface = Grey10,
)

@Composable
fun DigitalJournalTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = themeColors,
        content = content
    )
}