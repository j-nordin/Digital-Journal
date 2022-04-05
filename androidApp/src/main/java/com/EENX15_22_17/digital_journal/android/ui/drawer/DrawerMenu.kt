package com.EENX15_22_17.digital_journal.android.ui.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/* TODO: implement real drawer */

private val screens = listOf("Find Trips", "My Trips", "Saved Trips", "Price Alerts", "My Account")



@Composable
fun DrawerMenu(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        for (screen in screens) {
            Spacer(Modifier.height(24.dp))
            Text(text = screen, style = MaterialTheme.typography.h4)
        }
    }
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