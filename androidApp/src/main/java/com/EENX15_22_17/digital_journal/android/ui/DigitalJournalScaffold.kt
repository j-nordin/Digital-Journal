package com.EENX15_22_17.digital_journal.android.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.EENX15_22_17.digital_journal.android.ui.drawer.DrawerMenu
import com.EENX15_22_17.digital_journal.android.ui.drawer.DrawerShape

@Composable
fun DigitalJournalScaffold(
    scaffoldState: ScaffoldState,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        /*modifier = Modifier.statusBarsPadding(),*/
        drawerContent = {
            DrawerMenu()
        },
        drawerShape = DrawerShape(),
        content = content
    )
}
