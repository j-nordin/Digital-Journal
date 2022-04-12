package com.EENX15_22_17.digital_journal.android.ui.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.SwitchAccount
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun DrawerMenu(
    modifier: Modifier = Modifier,
    navToCurrPatients: () -> Unit = {}
) {
    DrawerHeader(modifier)
    DrawerDivider()
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
                    contentDescription = "Switch account"
                )
            }
        }
        Text(
            modifier = modifier.padding(top = 8.dp),
            text = DrawerMenuViewModel.name,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun DrawerDivider() {
    Divider(
        modifier = Modifier
            .padding(15.dp)
            .height(4.dp)
            .fillMaxWidth(0.5f)
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