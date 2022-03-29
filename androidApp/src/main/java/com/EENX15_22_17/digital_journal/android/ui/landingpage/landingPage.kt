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
import com.EENX15_22_17.digital_journal.android.ui.theme.lineFourColor
import com.EENX15_22_17.digital_journal.android.ui.theme.lineOneCard
import com.EENX15_22_17.digital_journal.android.ui.theme.lineTwoCard

class landingPage {

    enum class NavigationEnum {
        ARRIVAL, DANGER, CONTACT_REASON, PREVIOUS_CARE, HEALTH_HISTORY, HEALTH_NOW, SUICIDE_ASSESSMENT, NURSING_NEED, MEDICAL_ORDER, INTERIM_JOURNAL
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
                    label = R.string.arrivalCard,
                    backgroundCol = lineOneCard,
                    modifier = Modifier
                        .height(90.dp)
                        .width(170.dp),
                    navTarget = NavigationEnum.ARRIVAL,
                    navigateToForm = navigateToForm
                )
                navigationCard(
                    label = R.string.hazardCard,
                    backgroundCol = lineOneCard,
                    modifier = Modifier
                        .height(90.dp)
                        .width(170.dp),
                    navTarget = NavigationEnum.DANGER,
                    navigateToForm = navigateToForm
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
                    label = R.string.contactReason,
                    backgroundCol = lineTwoCard,
                    modifier = Modifier
                        .height(90.dp)
                        .width(110.dp),
                    navTarget = NavigationEnum.CONTACT_REASON,
                    navigateToForm = navigateToForm
                )
                navigationCard(
                    label = R.string.previousCare,
                    backgroundCol = lineTwoCard,
                    modifier = Modifier
                        .height(90.dp)
                        .width(110.dp),
                    navTarget = NavigationEnum.PREVIOUS_CARE,
                    navigateToForm = navigateToForm
                )
                navigationCard(
                    label = R.string.healthHistory,
                    backgroundCol = lineTwoCard,
                    modifier = Modifier
                        .height(90.dp)
                        .width(110.dp),
                    navTarget = NavigationEnum.HEALTH_HISTORY,
                    navigateToForm = navigateToForm
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                navigationCard(
                    label = R.string.healthNow,
                    backgroundCol = lineTwoCard,
                    modifier = Modifier
                        .height(90.dp)
                        .width(160.dp),
                    navTarget = NavigationEnum.HEALTH_NOW,
                    navigateToForm = navigateToForm
                    )
                navigationCard(
                    label = R.string.suicideAssessment,
                    backgroundCol = lineTwoCard,
                    modifier = Modifier
                        .height(90.dp)
                        .width(160.dp),
                    navTarget = NavigationEnum.SUICIDE_ASSESSMENT,
                    navigateToForm = navigateToForm
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                navigationCard(
                    label = R.string.nursingNeed,
                    backgroundCol = lineFourColor,
                    modifier = Modifier
                        .height(90.dp)
                        .width(160.dp),
                    navTarget = NavigationEnum.NURSING_NEED,
                    navigateToForm = navigateToForm
                )
                navigationCard(
                    label = R.string.medicalOrder,
                    backgroundCol = lineFourColor,
                    modifier = Modifier
                        .height(90.dp)
                        .width(160.dp),
                    navTarget = NavigationEnum.MEDICAL_ORDER,
                    navigateToForm = navigateToForm
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                navigationCard(
                    label = R.string.interimJournal,
                    backgroundCol = lineFourColor,
                    modifier = Modifier
                        .height(90.dp)
                        .width(350.dp),
                    navTarget = NavigationEnum.INTERIM_JOURNAL,
                    navigateToForm = navigateToForm
                )
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
                    .padding(bottom = 5.dp, start = 5.dp, end = 5.dp, top = 5.dp),
                elevation = 5.dp
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
        modifier: Modifier,
        navTarget: NavigationEnum,
        navigateToForm: (nav: NavigationEnum) -> Unit
    ) {
        Card(
            modifier = modifier.clickable { navigateToForm(navTarget) },
            backgroundColor = backgroundCol,
        ) {
            Text(stringResource(label), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
}