import androidx.compose.ui.Modifier

/**
 * Applies the supplied [modifier] to the chain only if [condition] is `true`.
 */
fun Modifier.modifyIf(condition: Boolean, modifier: Modifier): Modifier =
    if (condition) {
        this.then(modifier)
    } else {
        this
    }