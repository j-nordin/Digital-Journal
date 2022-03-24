package com.EENX15_22_17.digital_journal.android.ui.arrivalpage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField

@Composable
fun ArrivalContent(arrivalViewModel: ArrivalViewModel = ArrivalViewModel()) {
    ArrivalTime(arrivalViewModel.arrivalStates)
}

@Composable
fun ArrivalTime(arrivalData: ArrivalDataClass) {
    Row(modifier = Modifier.padding(16.dp)) {
        Icon(
            imageVector = Icons.Rounded.CalendarToday,
            contentDescription = "calendar"
        )
        TitledTextField(
            placeHolderText = "Aa",
            title = stringResource(id = R.string.arrivalTime),
            onChangeText = {
                arrivalData.timestamp = it;
                println(arrivalData.timestamp)
            }
        )
    }
}