package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData


fun SuicideStepsList(): List<CheckBoxData> {
    return listOf(
        CheckBoxData(
            checkBoxName = "1. Nedstämdhet",
            checkBoxValue = false,
            checkBoxId = "depression"
        ),
        CheckBoxData(
            checkBoxName = "2. Livsleda, dödstankar",
            checkBoxValue = false,
            checkBoxId = "deathThoughts"
        ),
        CheckBoxData(
            checkBoxName = "3. Dödsönskan",
            checkBoxValue = false,
            checkBoxId = "deathWish"
        ),
        CheckBoxData(
            checkBoxName = "4. Suicidtankar",
            checkBoxValue = false,
            checkBoxId = "suicidalThoughts"
        ),
        CheckBoxData(
            checkBoxName = "5. Suicidimpulser",
            checkBoxValue = false,
            checkBoxId = "suicideImpulses"
        ),
        CheckBoxData(
            checkBoxName = "6. Suicidala avsikter eller planer",
            checkBoxValue = false,
            checkBoxId = "suicidalIntentions"
        ),
        CheckBoxData(
            checkBoxName = "7. Suicidhandling",
            checkBoxValue = false,
            checkBoxId = "suicideAct"
        ),

    )
}
