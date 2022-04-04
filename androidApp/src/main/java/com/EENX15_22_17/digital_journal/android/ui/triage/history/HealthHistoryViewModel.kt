package com.EENX15_22_17.digital_journal.android.ui.triage.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class HealthHistoryViewModel : ViewModel() {


    val somaticHealth: MutableLiveData<Set<SomaticHealthData>> by lazy {
        MutableLiveData<Set<SomaticHealthData>>(setOf<SomaticHealthData>())
    }


   /* val earlierHealthy: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val delirium: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val cardiovascular: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val ep: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val cerebrovascular: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val liverFailure: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val tablet: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val operation: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val heartFailure: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val kidneyFailure: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val lungDisease: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val diabetes: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val insulin: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val bleedingDisorder: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val malignancy: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }
    val other: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>() }*/
}


