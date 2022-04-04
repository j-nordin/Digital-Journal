package com.EENX15_22_17.digital_journal.android.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = primary,
    onPrimary = Color.White,
    secondary = secondary,
    onSecondary = Color.White,
    error = error,
    onError = Color.White,
    background = background,
    onBackground = onBackgound,
    surface = background,
    onSurface = onBackgound,
)

@Composable
fun DigitalJournalTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightThemeColors,
        typography = DigitalJournalTypograhy,
        content = content,
        shapes = DigitalJournalShapes
    )
}