package com.EENX15_22_17.digital_journal.android.ui.landingpage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.theme.arrivalCard
import com.EENX15_22_17.digital_journal.android.ui.theme.cardColor2

class landingPage {

    enum class NavigationEnum {
        ARRIVAL, DANGER, HEALTH
    }

    @Composable
    fun landingPage(
        navigateToForm: (nav: NavigationEnum) -> Unit = {
            println(1)
        }
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center
        )
        {
            InfoDisplay()
            Row(
                modifier = Modifier
                  .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ArrivalCard(navigateToForm)
                DangerCard(navigateToForm)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                ArrivalCard(navigateToForm)
                DangerCard(navigateToForm)
                ArrivalCard(navigateToForm)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                DangerCard(navigateToForm)
                DangerCard(navigateToForm)
            }
        }
    }

    @Composable
    fun InfoDisplay() {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, start = 5.dp, end = 5.dp, top = 5.dp)
            ){
                Row(){
                    Text("Namn: Erik Bengtsson", textAlign = TextAlign.Start)
                    Text("Personnummer: 1997001122-XXXX", textAlign = TextAlign.End)
                }
            }
        }
    }

    @Composable
    fun ArrivalCard(
        navigateToForm: (nav: NavigationEnum) -> Unit
    ) {
        Card(
            modifier = Modifier
                .height(100.dp)
                .width(80.dp)
                .clickable { navigateToForm(NavigationEnum.ARRIVAL) },
            backgroundColor = arrivalCard
        ) {
            Text(
                stringResource(R.string.arrivalCard),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }

    @Composable
    fun DangerCard(
        navigateToForm: (nav: NavigationEnum) -> Unit
    ) {
        Card(
            modifier = Modifier
                .height(100.dp)
                .clickable { navigateToForm(NavigationEnum.DANGER) },
            backgroundColor = cardColor2

        ) {
            Text(stringResource(R.string.hazardCard), fontWeight = FontWeight.Bold)
        }
    }


}