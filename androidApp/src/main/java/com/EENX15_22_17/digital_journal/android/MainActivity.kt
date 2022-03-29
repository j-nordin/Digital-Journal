package com.EENX15_22_17.digital_journal.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalPage
import com.EENX15_22_17.digital_journal.android.ui.components.CheckButton
import com.EENX15_22_17.digital_journal.android.ui.components.CheckButtonWithText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArrivalPage()
        }
    }
}
