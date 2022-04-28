package com.EENX15_22_17.digital_journal.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.TextStyles

@Composable
fun DetailPageWrapper(
    title: String = "Title",
    titleColor: Color = Color.Blue,
    bgColor: Color = lerp(titleColor, Color.White, 0.70f),
    onMenuClicked: () -> Unit = {},
    onBackClicked: () -> Unit = {},
    content: @Composable () -> Unit = { }
) {
    Column(Modifier.padding(top = 16.dp, start = 8.dp, end = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MenuButton(modifier = Modifier.size(32.dp), onClick = onMenuClicked)
            BackButton(text = "TILLBAKA", onClick = onBackClicked)
        }
        Column(Modifier.padding(horizontal = 48.dp)) {
            ScreenTitleText(
                text = title.uppercase(),
                textColor = titleColor,
                lineColor = bgColor
            )
            content()
        }
    }
}

@Composable
fun ScreenTitleText(
    modifier: Modifier = Modifier,
    text: String = "SampleTitle",
    textColor: Color = Color.Blue,
    lineColor: Color = lerp(textColor, Color.White, 0.70f),
    underLine: Boolean = true
) {
    Column(modifier) {
        Text(
            text = text,
            color = textColor,
            style = TextStyles.pageTitle
        )
        if (underLine) {
            Underline(color = lineColor, thickness = 8.dp)
        }
    }
}

@Composable
fun Underline(
    modifier: Modifier = Modifier,
    color: Color = Color.Blue,
    thickness: Dp = 8.dp,
    cornerRoundingPercentage: Int = 50
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(thickness)
            .background(color, RoundedCornerShape(cornerRoundingPercentage))
    )
}

@Preview
@Composable
fun MenuButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    IconButton(onClick = onClick) {
        Icon(
            modifier = modifier,
            imageVector = Icons.Filled.Menu,
            contentDescription = "Menu"
        )
    }
}

@Preview
@Composable
fun BackButton(
    text: String = "Back",
    icon: ImageVector = Icons.Filled.ArrowBackIos,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onClick) {
            Icon(icon, "Back")
        }
        Text(
            text = text,
            style = TextStyles.iosButton
        )
    }
}