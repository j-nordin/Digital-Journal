package com.EENX15_22_17.digital_journal.android.screens.landingpage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MedicalInformation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.EENX15_22_17.digital_journal.android.R
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.components.CardChip
import com.EENX15_22_17.digital_journal.android.ui.components.CardChipWithBorders
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSectionWithRettsColor
import com.EENX15_22_17.digital_journal.android.ui.ifMobile
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import com.EENX15_22_17.digital_journal.android.ui.theme.TextStyles
import com.EENX15_22_17.digital_journal.android.ui.theme.colorIcon
import se.predicare.journal.data.Labels.labels
import se.predicare.journal.screens.HazardAssessmentDto
import se.predicare.journal.screens.JournalScreen
import se.predicare.journal.screens.PatientInformationDto
import se.predicare.journal.screens.SomaticHealthDto

val navigationSections by lazy {
    arrayOf(
        arrayOf(
            JournalScreen.PATIENT_INFORMATION,
            JournalScreen.ARRIVAL_HAZARD_ASSESSMENT,
        ),
        arrayOf(
            JournalScreen.CONTACT_REASON,
            JournalScreen.SUICIDE_ASSESSMENT
        ),
        arrayOf(
            JournalScreen.PREVIOUS_CARE,
            JournalScreen.SOMATIC_HEALTH,
            JournalScreen.TRIAGE_ASSESSMENT,
        ),
        arrayOf(
            JournalScreen.EVENTS
        ),
        arrayOf(
            JournalScreen.INTERIM_JOURNAL
        )
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandingPage(
    visitId: String = "1",
    showOverview: (patientId: String) -> Unit = {},
    onNavigate: (destination: JournalScreen) -> Unit = {},
    landingPageViewModel: LandingPageViewModel
) {
    val patient by landingPageViewModel.patient.collectAsState()
    val patientHazardAssessment by landingPageViewModel.patientHazardAssessment.collectAsState()
    val somaticHealth by landingPageViewModel.somaticHealth.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(62.dp ifMobile 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp ifMobile 8.dp),
    ) {
        stickyHeader {
            InfoDisplay(
                patient = patient,
                patientHazardAssessment = patientHazardAssessment,
                somaticHealth = somaticHealth
            )
        }
        items(navigationSections.size) { index ->
            val screens = navigationSections[index]
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp ifMobile 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                screens.forEach { screen ->
                    NavigationCard(
                        modifier = Modifier
                            .height(140.dp ifMobile 100.dp)
                            .weight(1.0f / screens.size.toFloat()),
                        label = JournalScreen.labels[screen]!!,
                        titleColor = Colors.journalSectionColors[screen.section]!!,
                        navigateToForm = { onNavigate(screen) }
                    )
                }
            }
        }
    }
}

@Composable
fun InfoDisplay(
    patient: PatientInformationDto.Patient,
    patientHazardAssessment: HazardAssessmentDto,
    somaticHealth: SomaticHealthDto
) {
    TitledSectionWithRettsColor(title = stringResource(id = R.string.patientJouralTitle)) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                Text(
                    text = "Namn: " + patient.name,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Personnummer: " + patient.personalId,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            BVCActions(
                hazardAssessmentDto = patientHazardAssessment
            )
            NursingCareContent(somaticHealthDto = somaticHealth)
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
            .clickable { navigateToForm() }
            .padding(2.dp), // Same as shadow elevation since its otherwise cut-of
        backgroundColor = backgroundColor,
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = TextStyles.cardTitle,
                color = titleColor,
                textAlign = TextAlign.Center
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

@Composable
fun BVCActions(
    hazardAssessmentDto: HazardAssessmentDto,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
        Row {
            Text(
                text = "BVC-poäng: ",
                fontWeight = FontWeight.ExtraBold
            )
            CardChip(
                value = hazardAssessmentDto.hazardAssessmentStatements.size.toString(),
                color = Color.Red
            )
        }

        Row {
            Text(
                text = "Vidtagna åtgärder: ",
                fontWeight = FontWeight.ExtraBold
            )
            if (hazardAssessmentDto.hazardAssessmentActionsTaken != null) {
                Text(text = hazardAssessmentDto.hazardAssessmentActionsTaken!!)
            } else {
                Text(text = "Inga åtgärder tagna")
            }
        }
    }
}

@Composable
fun NursingCareContent(
    somaticHealthDto: SomaticHealthDto
) {
    Row(modifier = Modifier.padding(top = 16.dp)) {
        Text(
            text = "Omvårdnatdsbehov: ",
            fontWeight = FontWeight.ExtraBold
        )
        //TODO: Value should be Ja or Nej
        CardChip(
            value = somaticHealthDto.requiresNursingCare.name,
            color = Color.Red
        )
        Row(
            modifier = Modifier.padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (somaticHealthDto.requiredNursingCare.size > 0) {
                somaticHealthDto.requiredNursingCare.forEach { nursingCare ->
                    //TODO: value should be real nursingCare Strings
                    CardChipWithBorders(
                        modifier = Modifier
                            .width(120.dp)
                            .height(30.dp),
                        value = nursingCare.name,
                        backgroundColor = Color.White,
                        color = Colors.triagePrimary,
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Colors.triagePrimary)
                    )
                }
            } else {
                //TODO: Remove, just temporary to see how it looks
                CardChipWithBorders(
                    modifier = Modifier
                        .width(120.dp)
                        .height(30.dp),
                    value = "VÄTSKEINTAG",
                    backgroundColor = Color.White,
                    color = Colors.triagePrimary,
                    shape = CircleShape,
                    border = BorderStroke(2.dp, Colors.triagePrimary)
                )
                CardChipWithBorders(
                    modifier = Modifier
                        .width(120.dp)
                        .height(30.dp),
                    value = "GÅ+STÅ",
                    color = Colors.triagePrimary,
                    backgroundColor = Color.White,
                    shape = CircleShape,
                    border = BorderStroke(2.dp, Colors.triagePrimary)
                )
            }
        }
    }
}


