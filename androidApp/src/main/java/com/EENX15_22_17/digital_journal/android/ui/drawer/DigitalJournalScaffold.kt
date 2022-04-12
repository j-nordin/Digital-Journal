package com.EENX15_22_17.digital_journal.android.ui.drawer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.EENX15_22_17.digital_journal.android.ui.drawer.DrawerMenu
import com.EENX15_22_17.digital_journal.android.ui.drawer.DrawerShape

@Composable
fun DigitalJournalScaffold(
    scaffoldState: ScaffoldState,
    navToCurrPatients: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        /*modifier = Modifier.statusBarsPadding(),*/
        drawerContent = {
            DrawerMenu(
                navToCurrPatients = navToCurrPatients
            )
        },
        drawerShape = DrawerShape(),
        content = content
    )
}

class DrawerShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(
            Rect(
                left = 0f,
                top = 0f,
                right = size.width * 0.35f,
                bottom = size.height
            )
        )
    }
}