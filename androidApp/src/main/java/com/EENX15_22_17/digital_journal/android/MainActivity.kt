package com.EENX15_22_17.digital_journal.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //CurrentPatientsList().PatientsList()
//            CheckButton(handleSelected = { println(it)})
//            CheckButtonWithText(text = "this is a button text", handleSelected = { println(it)})
        }
    }
}
