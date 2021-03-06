package com.EENX15_22_17.digital_journal.android.screens.landingpage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.screens.journal.JournalEntrySummaryCard
import com.EENX15_22_17.digital_journal.android.screens.journal.JournalEntryViewModel
import com.EENX15_22_17.digital_journal.android.ui.ifMobile
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import com.EENX15_22_17.digital_journal.android.ui.theme.TextStyles
import org.kodein.di.compose.androidContextDI
import org.kodein.di.instance
import se.predicare.journal.data.Labels.labels
import se.predicare.journal.screens.JournalScreen

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
@Preview
fun JournalEntryOverviewScreen(
    journalId: String = "1",
    showOverview: (patientId: String) -> Unit = {},
    onNavigate: (destination: JournalScreen) -> Unit = {}
) {

    val di = androidContextDI()
    //TODO: Use args in instance to get the real journalId.
    val journalViewModel: JournalEntryViewModel by di.instance(arg = journalId)
    val journal by journalViewModel.journal.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(62.dp ifMobile 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp ifMobile 8.dp),
    ) {
        stickyHeader {
            JournalEntrySummaryCard(journal = journal)
        }
        items(navigationSections.size) { index ->
            val screens = navigationSections[index]
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp ifMobile 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                screens.forEach { screen ->
                    JournalSectionNavigationCard(
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
fun JournalSectionNavigationCard(
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
