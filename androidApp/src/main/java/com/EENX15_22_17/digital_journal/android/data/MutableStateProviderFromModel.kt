package com.EENX15_22_17.digital_journal.android.data

import androidx.compose.runtime.MutableState

/**
 * Same as [MutableStateProviderFor], but maintains its own [model] object which has the registered
 * state values saved to/loaded from it when accessed/written.
 */
open class MutableStateProviderFromModel<ModelT : Any>(initialValue: ModelT) :
    MutableStateProviderFor<ModelT>() {

    private var internalModel: ModelT = initialValue

    /**
     * [model] of [ModelT] which is synced with the registered [MutableState] when it is accessed or
     * written.
     */
    var model: ModelT
        get() {
            saveStatesToModel()
            return internalModel
        }
        set(value) {
            internalModel = value
            loadStatesFromModel()
        }

    /**
     * Same as [MutableStateProviderFor.saveStatesToModel] but with the internal [model].
     */
    fun saveStatesToModel() = saveStatesToModel(internalModel)

    /**
     * Same as [MutableStateProviderFor.loadStatesFromModel] but using the internal [model].
     */
    fun loadStatesFromModel() = loadStatesFromModel(internalModel)
}