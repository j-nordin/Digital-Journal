package com.EENX15_22_17.digital_journal.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.EENX15_22_17.digital_journal.android.ui.currentpatients.CurrentPatientItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //HelloWorld()
            CurrentPatientItem().PatientCard(name = "PatientNamn",
                securityNumber = "19990502-xxxx")
        }
    }
}

@Composable
fun HelloWorld() {
    return Row() {
        Text(stringResource(R.string.helloworld))
    }
}


