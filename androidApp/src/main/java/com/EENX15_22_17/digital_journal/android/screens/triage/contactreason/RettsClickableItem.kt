package com.EENX15_22_17.digital_journal.android.screens.triage.contactreason


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorIcon
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray

@Composable
fun RettsClickableItem(
    item: RettsClickableData,
    onClick: () -> Unit
) {
    Column(modifier = Modifier.padding(bottom = 10.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(BorderStroke(2.dp, colorTextGray), shape = RoundedCornerShape(20.dp))
                .padding(5.dp)

        ) {
            Canvas(modifier = Modifier.size(20.dp), onDraw = {
                drawCircle(color = item.color)
            })
            Text(
                text = item.data,
                color = colorTextGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
            )
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "Delete",
                tint = colorIcon,
                modifier = Modifier.clickable { onClick() }
            )
        }
    }
}