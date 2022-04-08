package com.EENX15_22_17.digital_journal.android.ui.landingpage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MedicalInformation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import com.EENX15_22_17.digital_journal.android.ui.theme.TextStyles
import com.EENX15_22_17.digital_journal.android.ui.theme.colorIcon


@Composable
fun LandingPage(
    visitId: String,
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
            NavigationCard(
                label = stringResource(R.string.arrivalCard),
                titleColor = Colors.arrivalPrimary,
                modifier = Modifier.width(370.dp),
                navigateToForm = navToArrival
            )
            NavigationCard(
                label = stringResource(R.string.hazardCard),
                titleColor = Colors.arrivalPrimary,
                modifier = Modifier.width(370.dp),
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
            NavigationCard(
                label = stringResource(R.string.contactReason),
                titleColor = Colors.triagePrimary,
                modifier = Modifier
                    .width(240.dp),
                navigateToForm = navToContactReason
            )
            NavigationCard(
                label = stringResource(R.string.previousCare),
                titleColor = Colors.triagePrimary,
                modifier = Modifier
                    .width(240.dp),
                navigateToForm = navToPreviousCare
            )
            NavigationCard(
                label = stringResource(R.string.healthHistory),
                titleColor = Colors.triagePrimary,
                modifier = Modifier
                    .width(240.dp),
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
            NavigationCard(
                label = stringResource(R.string.healthNow),
                titleColor = Colors.triagePrimary,
                modifier = Modifier
                    .width(370.dp),
                navigateToForm = navToHealthNow
            )
            NavigationCard(
                label = stringResource(R.string.suicideAssessment),
                titleColor = Colors.triagePrimary,
                modifier = Modifier
                    .width(370.dp),
                navigateToForm = navToSuicideAssessment
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NavigationCard(
                label = stringResource(R.string.nursingNeed),
                titleColor = Colors.treatmentPrimary,
                modifier = Modifier
                    .width(370.dp),
                navigateToForm = navToNursingNeed
            )
            NavigationCard(
                label = stringResource(R.string.medicalOrder),
                titleColor = Colors.treatmentPrimary,
                modifier = Modifier
                    .width(370.dp),
                navigateToForm = navToMedicalOrder
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NavigationCard(
                label = stringResource(R.string.interimJournal),
                titleColor = Colors.treatmentPrimary,
                modifier = Modifier
                    .width(760.dp),
                navigateToForm = navToInterimJournal
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            OverViewButton(showOverview = { showOverview(visitId) })
        }
    }
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
fun NavigationCard(
    modifier: Modifier = Modifier,
    label: String = "Title",
    titleColor: Color = Color.Blue,
    backgroundColor: Color = lerp(titleColor, Color.White, 0.70f),
    navigateToForm: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .height(180.dp)
            .clickable { navigateToForm() },
        backgroundColor = backgroundColor,
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = label,
                style = TextStyles.cardTitle,
                color = titleColor
            )
        }
    }
}

@Composable
fun OverViewButton(
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