package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData

@Composable
fun SuicideStepsList()  {
    return SuicideStepsItem(items = listOf(
        CheckBoxData(
            checkBoxName = "1. Nedstämdhet",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "2. Livsleda, dödstankar",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "3. Dödsönskan",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "4. Suicidtankar",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "5. Suicidimpulser",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "6. Suicidala avsikter eller planer",
            checkBoxValue = false,
        ),
        CheckBoxData(
            checkBoxName = "7. Suicidhandling",
            checkBoxValue = false,
        ),

        )
    )
}


/*  val depression : Boolean,
    val deathThoughts : Boolean,
    val deathWish : Boolean,
    val suicidalThoughts : Boolean,
    val suicideImpulses : Boolean,
    val suicidalIntentions : Boolean,
    val suicideAct : Boolean
*/
