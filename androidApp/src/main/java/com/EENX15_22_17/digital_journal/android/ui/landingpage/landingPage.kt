package com.EENX15_22_17.digital_journal.android.ui.landingpage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.theme.rettsLineFourNavigationCard
import com.EENX15_22_17.digital_journal.android.ui.theme.rettsLineOneNavigationCard
import com.EENX15_22_17.digital_journal.android.ui.theme.rettsLineTwoNavigationCard
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Alignment
import androidx.compose.material.*
import androidx.compose.material.icons.rounded.MedicalInformation
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorIcon


@Composable
fun LandingPage(
    showOverview: (patientId: String) -> Unit = {},
    navToArrival: () -> Unit = {},
    navToHazard: () -> Unit = {},
    navToContactReason: () -> Unit = {},
    navToPreviousCare: () -> Unit = {},
    navToHealthHistory: () -> Unit = {},
    navToHealthNow: () -> Unit = {},
    navToSuicideAssessment: () -> Unit = {},
    navToNursingNeed: () -> Unit = {},
    navToMedicalOrder: () -> Unit = {},
    navToInterimJournal: () -> Unit = {}

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
                backgroundCol = rettsLineOneNavigationCard,
                modifier = Modifier.width(370.dp),
                navTarget = NavigationEnum.ARRIVAL,
                navigateToForm = navToArrival
            )
            navigationCard(
                label = R.string.hazardCard,
                backgroundCol = rettsLineOneNavigationCard,
                modifier = Modifier.width(370.dp),
                navTarget = NavigationEnum.DANGER,
                navigateToForm = navToHazard
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
                label = R.string.contactReason,
                backgroundCol = rettsLineTwoNavigationCard,
                modifier = Modifier
                    .width(240.dp),
                navTarget = NavigationEnum.CONTACT_REASON,
                navigateToForm = navToContactReason
            )
            navigationCard(
                label = R.string.previousCare,
                backgroundCol = rettsLineTwoNavigationCard,
                modifier = Modifier
                    .width(240.dp),
                navTarget = NavigationEnum.PREVIOUS_CARE,
                navigateToForm = navToPreviousCare
            )
            navigationCard(
                label = R.string.healthHistory,
                backgroundCol = rettsLineTwoNavigationCard,
                modifier = Modifier
                    .width(240.dp),
                navTarget = NavigationEnum.HEALTH_HISTORY,
                navigateToForm = navToHealthHistory
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
                backgroundCol = rettsLineTwoNavigationCard,
                modifier = Modifier
                    .width(370.dp),
                navTarget = NavigationEnum.HEALTH_NOW,
                navigateToForm = navToHealthNow
            )
            navigationCard(
                label = R.string.suicideAssessment,
                backgroundCol = rettsLineTwoNavigationCard,
                modifier = Modifier
                    .width(370.dp),
                navTarget = NavigationEnum.SUICIDE_ASSESSMENT,
                navigateToForm = navToSuicideAssessment
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
                backgroundCol = rettsLineFourNavigationCard,
                modifier = Modifier
                    .width(370.dp),
                navTarget = NavigationEnum.NURSING_NEED,
                navigateToForm = navToNursingNeed
            )
            navigationCard(
                label = R.string.medicalOrder,
                backgroundCol = rettsLineFourNavigationCard,
                modifier = Modifier
                    .width(370.dp),
                navTarget = NavigationEnum.MEDICAL_ORDER,
                navigateToForm = navToMedicalOrder
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
                backgroundCol = rettsLineFourNavigationCard,
                modifier = Modifier
                    .width(760.dp),
                navTarget = NavigationEnum.INTERIM_JOURNAL,
                navigateToForm = navToInterimJournal
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            overViewButton(showOverview = showOverview)
        }
    }
}

/*
  TODO: refactor these to own file
   */
enum class NavigationEnum {
    ARRIVAL, DANGER, CONTACT_REASON, PREVIOUS_CARE, HEALTH_HISTORY, HEALTH_NOW, SUICIDE_ASSESSMENT, NURSING_NEED, MEDICAL_ORDER, INTERIM_JOURNAL
}


/**
 * TODO: When we have avaialable patient data, this card is supposed to display patient information
 */
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
                .padding(bottom = 10.dp, start = 20.dp, end = 20.dp, top = 10.dp)
                .height(150.dp),
            elevation = 10.dp
        )
        {
            Text("Namn: Erik Bengtsson", textAlign = TextAlign.Start, fontSize = 20.sp)
            Text("ID: 1997001122-XXXX", textAlign = TextAlign.End, fontSize = 20.sp)
        }
    }
}


@Composable
fun navigationCard(
    label: Int,
    backgroundCol: Color,
    modifier: Modifier,
    navTarget: NavigationEnum,
    navigateToForm: () -> Unit
) {
    Card(
        modifier = modifier
            .height(180.dp)
            .clickable { navigateToForm() },
        backgroundColor = backgroundCol,
    ) {
        Text(
            stringResource(label),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
    }
}

@Composable
fun overViewButton(
    showOverview: (patientId: String) -> Unit = {}
) {
    IconButton(
        onClick = { showOverview("") }) {
        Icon(
            imageVector = Icons.Rounded.MedicalInformation,
            contentDescription = "Overview",
            tint = colorIcon
        )
    }
}
