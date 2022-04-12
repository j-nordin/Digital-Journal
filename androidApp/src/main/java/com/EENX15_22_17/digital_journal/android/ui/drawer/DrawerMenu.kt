package com.EENX15_22_17.digital_journal.android.ui.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
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
    navToCurrPatients: () -> Unit
) {
    DrawerHeader()
}

@Composable
fun DrawerHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = modifier.padding(top = 15.dp, start = 10.dp),
            text = DrawerMenuViewModel.loggedInState,
            style = MaterialTheme.typography.h5
        )
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