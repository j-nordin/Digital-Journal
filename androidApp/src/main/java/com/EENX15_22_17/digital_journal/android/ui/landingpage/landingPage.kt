package com.EENX15_22_17.digital_journal.android.ui.landingpage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.theme.lineOneCard
import com.EENX15_22_17.digital_journal.android.ui.theme.lineTwoCard

class landingPage {

    enum class NavigationEnum {
        ARRIVAL, DANGER, CONTACT_REASON, PREVIOUS_CARE, HEALTH_HISTORY, HEALTH_NOW
    }

    object ModifierProvider {

        fun lineOneModifier(
            NavigationTarget: NavigationEnum,
            navigateToForm: (nav: NavigationEnum) -> Unit = {}
        ): Modifier {
            return if (NavigationTarget == NavigationEnum.ARRIVAL || NavigationTarget == NavigationEnum.DANGER) {
                Modifier
                    .height(100.dp)
                    .width(170.dp)
                    .clickable { navigateToForm(NavigationTarget) }
            } else if (NavigationTarget == NavigationEnum.CONTACT_REASON || NavigationTarget == NavigationEnum.PREVIOUS_CARE || NavigationTarget == NavigationEnum.HEALTH_HISTORY) {
                return Modifier
                    .width(110.dp)
                    .height(100.dp)
                    .clickable { navigateToForm(NavigationTarget) }
            } else {
                return Modifier.width(100.dp)
            }
        }
    }

    @Composable
    fun landingPage(
        navigateToForm: (nav: NavigationEnum) -> Unit = {}
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
                navigationCard(
                    R.string.arrivalCard,
                    lineOneCard,
                    ModifierProvider.lineOneModifier(NavigationEnum.ARRIVAL, navigateToForm)
                )
                navigationCard(
                    R.string.hazardCard,
                    lineOneCard,
                    ModifierProvider.lineOneModifier(NavigationEnum.DANGER, navigateToForm)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                navigationCard(
                    R.string.contactReason,
                    lineTwoCard,
                    ModifierProvider.lineOneModifier(NavigationEnum.CONTACT_REASON, navigateToForm)
                )
                navigationCard(
                    R.string.previousCare,
                    lineTwoCard,
                    ModifierProvider.lineOneModifier(NavigationEnum.PREVIOUS_CARE, navigateToForm)
                )
                navigationCard(
                    R.string.healthHistory,
                    lineTwoCard,
                    ModifierProvider.lineOneModifier(NavigationEnum.HEALTH_HISTORY, navigateToForm)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
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
            ) {
                Row() {
                    Text("Namn: Erik Bengtsson", textAlign = TextAlign.Start)
                    Text("Personnummer: 1997001122-XXXX", textAlign = TextAlign.End)
                }
            }
        }
    }

    @Composable
    fun navigationCard(
        label: Int,
        backgroundCol: Color,
        modifier: Modifier
    ) {
        Card(
            modifier = modifier,
            backgroundColor = backgroundCol
        ) {
            Text(stringResource(label), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
}