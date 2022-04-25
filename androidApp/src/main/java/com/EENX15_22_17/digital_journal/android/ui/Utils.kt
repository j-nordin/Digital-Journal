package com.EENX15_22_17.digital_journal.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Returns `true` if the screen size is indicative of a mobile device rather than a tablet.
 */
@Composable
fun isMobileScreen(): Boolean {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    return screenWidth > 10.cm && screenHeight > 10.cm
}

/**
 * Applies the supplied [modifier] to the chain only if [condition] is `true`.
 */
fun Modifier.modifyIf(condition: Boolean, modifier: Modifier): Modifier =
    if (condition) {
        this.then(modifier)
    } else {
        this
    }

/**
 * Converts this [Number] in centimeters to the corresponding length in display-pixels ([Dp])
 */
val Number.cm: Dp
    get() = Dp(this.toFloat() * 62.992126f)

/**
 * Converts a measurement in [Dp]s into a float representing the same measurement in centimeters.
 */
val Dp.cm: Float
    get() = (this.value / 62.992126f)

/**
 * infix function to specify an alternate size [mobileDp] if running on a mobile device.
 */
@Composable
infix fun Dp.ifMobile(mobileDp: Dp): Dp {
    return if (isMobileScreen()) {
        this
    } else {
        mobileDp
    }
}
