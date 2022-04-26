package com.EENX15_22_17.digital_journal.android.screens.landingpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.predicare.journal.repository.JournalRepository
import se.predicare.journal.screens.HazardAssessmentDto
import se.predicare.journal.screens.PatientInformationDto
import se.predicare.journal.screens.SomaticHealthDto

class LandingPageViewModel(
    val journalRepo: JournalRepository,
    val journalid: String
) : ViewModel() {
    private val _patient =
        MutableStateFlow<PatientInformationDto.Patient>(PatientInformationDto.Patient())
    val patient = _patient.asStateFlow()

    private val _patientHazardAssessment =
        MutableStateFlow<HazardAssessmentDto>(HazardAssessmentDto())
    val patientHazardAssessment = _patientHazardAssessment.asStateFlow()

    private val _somaticHealth =
        MutableStateFlow<SomaticHealthDto>(SomaticHealthDto())
    val somaticHealth = _somaticHealth.asStateFlow()

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch {
            _patient.emit(
                journalRepo.get(journalid)?.patientInfo?.patientData
                    ?: PatientInformationDto.Patient()
            )
            _patientHazardAssessment.emit(
                journalRepo.get(journalid)?.hazardAssessment ?: HazardAssessmentDto()
            )
            _somaticHealth.emit(
                journalRepo.get(journalid)?.somaticHealth ?: SomaticHealthDto()
            )
        }
    }
}