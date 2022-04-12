package com.EENX15_22_17.digital_journal.android.ui.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.SwitchAccount
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.brighter
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray
import com.EENX15_22_17.digital_journal.android.ui.theme.primary


@Preview(showBackground = true)
@Composable
fun DrawerMenu(
    modifier: Modifier = Modifier,
    navToCurrPatients: () -> Unit = {}
) {
    DrawerHeader(modifier = modifier)
    DrawerDivider(modifier = modifier)
/*    DrawerBody()
    DrawerFooter()*/
}

@Preview(showBackground = true)
@Composable
fun DrawerHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(
                start = 15.dp,
                top = 15.dp,
                end = 15.dp,
                bottom = 8.dp
            )
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier,
                text = DrawerMenuViewModel.loggedInState,
                style = MaterialTheme.typography.h5
            )
            IconButton(
                onClick = { /*TODO: Implement onSwitchAccount function*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.SwitchAccount,
                    contentDescription = "Switch account",
                    tint = primary.brighter(0.1f)
                )
            }
        }
        Text(
            modifier = modifier.padding(top = 8.dp),
            text = DrawerMenuViewModel.name,
            style = MaterialTheme.typography.body1
        )
        Text(
            modifier = modifier.padding(top = 6.dp),
            text = DrawerMenuViewModel.role,
            style = MaterialTheme.typography.body2,
            color = colorTextGray
        )
    }
}

@Composable
fun DrawerDivider(
    modifier: Modifier = Modifier
) {
    Divider(
        modifier = modifier
            .padding(
                vertical = 10.dp,
                horizontal = 15.dp
            )
            .fillMaxWidth(),
        thickness = 2.dp
    )
    Spacer(
        modifier = Modifier.height(10.dp)
    )
}


@Composable
fun DrawerBody() {

}


@Composable
fun DrawerFooter() {
    TODO("Not yet implemented")
}