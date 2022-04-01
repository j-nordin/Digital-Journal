package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.suicideSteps.SuicideStepsData

@Composable
fun SuicideStepsList()  {
    return SuicideStepSection(items = listOf(
        SuicideStepsData(
            checkBoxName = "1. Nedstämdhet",
            checkBoxValue = false,
        ),
        SuicideStepsData(
            checkBoxName = "2. Livsleda, dödstankar",
            checkBoxValue = false,
        ),
        SuicideStepsData(
            checkBoxName = "3. Dödsönskan",
            checkBoxValue = false,
        ),
        SuicideStepsData(
            checkBoxName = "4. Suicidtankar",
            checkBoxValue = false,
        ),
        SuicideStepsData(
            checkBoxName = "5. Suicidimpulser",
            checkBoxValue = false,
        ),
        SuicideStepsData(
            checkBoxName = "6. Suicidala avsikter eller planer",
            checkBoxValue = false,
        ),
        SuicideStepsData(
            checkBoxName = "7. Suicidhandling",
            checkBoxValue = false,
        ),

        ))
}


/*  val depression : Boolean,
    val deathThoughts : Boolean,
    val deathWish : Boolean,
    val suicidalThoughts : Boolean,
    val suicideImpulses : Boolean,
    val suicidalIntentions : Boolean,
    val suicideAct : Boolean
*/
