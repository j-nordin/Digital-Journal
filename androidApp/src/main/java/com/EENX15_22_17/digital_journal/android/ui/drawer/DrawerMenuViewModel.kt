package com.EENX15_22_17.digital_journal.android.ui.drawer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// TODO: Should fetch from backend
object DrawerMenuViewModel : ViewModel() {
    val loggedInState = "Inloggad"
    val name = "Ulla Göransson"
    val role = "Sjuksköterska"
}