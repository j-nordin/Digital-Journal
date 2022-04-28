package com.EENX15_22_17.digital_journal.android.screens.journal.triage.somaticHealth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.EENX15_22_17.digital_journal.android.dataModel.NursesNeeds
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo

class SomaticHealthViewModel : ViewModel() {


    val somaticHealth: MutableLiveData<Set<SomaticHealthData>> by lazy {
        MutableLiveData<Set<SomaticHealthData>>(setOf<SomaticHealthData>())
    }

    val isBloodInfection: MutableLiveData<YesNo> by lazy {
        MutableLiveData<YesNo>(YesNo.UNKOWN)
    }

    val bloodInfectionType: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val isHyperSensitive: MutableLiveData<YesNo> by lazy {
        MutableLiveData<YesNo>(YesNo.UNKOWN)
    }

    val hyperSensitiveType: MutableLiveData<String> by lazy {
        MutableLiveData<String>("")
    }

    val isMultiresistant: MutableLiveData<YesNo> by lazy {
        MutableLiveData<YesNo>(YesNo.UNKOWN)
    }

    val suspicionGE: MutableLiveData<YesNo> by lazy {
        MutableLiveData<YesNo>(YesNo.UNKOWN)
    }

    val isNursesNeed: MutableLiveData<YesNo> by lazy {
        MutableLiveData<YesNo>(YesNo.UNKOWN)
    }

    val nursesNeedsAlternatives: MutableLiveData<Set<NursesNeeds>> by lazy {
        MutableLiveData<Set<NursesNeeds>>(setOf<NursesNeeds>())
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
     val other: MutableLiveData<YesNo> by lazy { MutableLiveData<YesNo>()*/
}


