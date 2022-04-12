package com.EENX15_22_17.digital_journal.android.ui.drawer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun DigitalJournalScaffold(
    scaffoldState: ScaffoldState,
    navToCurrPatients: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val drawerWidthDp = LocalConfiguration.current.screenWidthDp.dp * 0.5f
    val drawerWidthPx = with(LocalDensity.current) { drawerWidthDp.toPx() }

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerMenu(
                modifier = Modifier
                    .widthIn(max = drawerWidthDp),
                navToCurrPatients = navToCurrPatients
            )
        },
        drawerShape = DrawerShape(
            width = drawerWidthPx
        ),
        content = content
    )
}

class DrawerShape(
    val width: Float
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(
            Rect(
                left = 0f,
                top = 0f,
                right = width,
                bottom = size.height
            )
        )
    }
}