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

    object ModifierProvider {

        fun cardModifier(
            NavigationTarget: NavigationEnum,
            navigateToForm: (nav: NavigationEnum) -> Unit = {}
        ): Modifier {
            return if (NavigationTarget == NavigationEnum.ARRIVAL || NavigationTarget == NavigationEnum.DANGER) {
                Modifier
                    .height(90.dp)
                    .width(170.dp)
                    .clickable { navigateToForm(NavigationTarget) }
            } else if (NavigationTarget == NavigationEnum.CONTACT_REASON || NavigationTarget == NavigationEnum.PREVIOUS_CARE || NavigationTarget == NavigationEnum.HEALTH_HISTORY) {
                return Modifier
                    .height(90.dp)
                    .width(110.dp)
                    .clickable { navigateToForm(NavigationTarget) }
            } else if (NavigationTarget == NavigationEnum.HEALTH_NOW || NavigationTarget == NavigationEnum.SUICIDE_ASSESSMENT) {
                return Modifier
                    .height(90.dp)
                    .width(160.dp)
                    .clickable { navigateToForm(NavigationTarget) }
            } else if (NavigationTarget == NavigationEnum.NURSING_NEED || NavigationTarget == NavigationEnum.MEDICAL_ORDER) {
                return Modifier
                    .height(90.dp)
                    .width(160.dp)
                    .clickable { navigateToForm(NavigationTarget) }
            } else {
                Modifier
                    .height(90.dp)
                    .width(350.dp)
                    .clickable { navigateToForm(NavigationTarget) }
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
                    label =
                    R.string.arrivalCard,
                    backgroundCol = lineOneCard,
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.ARRIVAL,
                        navigateToForm
                    )
                )
                navigationCard(
                    label = R.string.hazardCard,
                    backgroundCol = lineOneCard,
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.DANGER,
                        navigateToForm
                    )
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
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.CONTACT_REASON,
                        navigateToForm
                    )
                )
                navigationCard(
                    label = R.string.previousCare,
                    backgroundCol = lineTwoCard,
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.PREVIOUS_CARE,
                        navigateToForm
                    )
                )
                navigationCard(
                    label = R.string.healthHistory,
                    backgroundCol = lineTwoCard,
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.HEALTH_HISTORY,
                        navigateToForm
                    )
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
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.HEALTH_NOW,
                        navigateToForm
                    )
                )
                navigationCard(
                    label = R.string.suicideAssessment,
                    backgroundCol = lineTwoCard,
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.SUICIDE_ASSESSMENT,
                        navigateToForm
                    )
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
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.NURSING_NEED,
                        navigateToForm
                    )
                )
                navigationCard(
                    label = R.string.medicalOrder,
                    backgroundCol = lineFourColor,
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.MEDICAL_ORDER,
                        navigateToForm
                    )
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
                    modifier = ModifierProvider.cardModifier(
                        NavigationEnum.INTERIM_JOURNAL,
                        navigateToForm
                    )
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
            backgroundColor = backgroundCol,
        ) {
            Text(stringResource(label), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
}