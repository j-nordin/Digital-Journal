package com.EENX15_22_17.digital_journal.android.ui.contactcause


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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorIcon
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray

@Composable
fun RettsClickableSection(
    items : MutableList<RettsClickableData>
) {
    val scrollState = rememberScrollState()
    Box(modifier = Modifier
        .size(width = 600.dp, height = 250.dp)
        .verticalScroll(scrollState)) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            if (items.isNullOrEmpty()) {
                Text(
                    text = " -> Retts! ",
                    color = colorTextGray,
                    fontSize = 24.sp)
            } else {
                var listOfItems by remember {
                    mutableStateOf(items) }

                listOfItems.forEachIndexed { _, item ->

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .border(BorderStroke(2.dp , colorTextGray), shape = RoundedCornerShape(20.dp))
                            .padding(10.dp)

                    ) {
                        Canvas(modifier = Modifier.size(20.dp), onDraw = {
                            drawCircle(color = item.color)
                        })
                        Text(
                            text = " " + item.data + " ",
                            color = colorTextGray,
                            fontSize = 16.sp)
                        // TODO: Implement delete operation
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = "Comments",
                            tint = colorIcon,
                            modifier = Modifier.clickable { listOfItems.remove(item); println(listOfItems.size); println("Items "+items.size) }
                        )
                    }
                    Box(modifier = Modifier
                        .size(width = 20.dp, height = 20.dp))
                }
            }
        }
    }
}