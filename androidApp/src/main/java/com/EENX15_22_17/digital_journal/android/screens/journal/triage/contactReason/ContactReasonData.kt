package com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason

import android.util.Log
import androidx.compose.runtime.*
import se.predicare.journal.screens.ContactReasonDto
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

open class MutableStateProviderFor<ModelT : Any>(kClass: KClass<ModelT>) {
    val TAG = "ContactReasonData"
    //private val registeredStateProviders: MutableMap<KProperty1<ModelT, *>, MutableState<*>> = mutableMapOf()

    private val stateSavers: MutableMap<KProperty1<*, *>, ((ModelT) -> Unit)> = mutableMapOf()
    private val stateUpdaters: MutableMap<KProperty1<*, *>, ((ModelT) -> Unit)> =
        mutableMapOf()

    //private val properties = kClass.members.filterIsInstance<KMutableProperty1<ModelT, *>>()

    fun <PropT> stateOf(property: KMutableProperty1<ModelT, PropT?>): MutableState<PropT?> {
        val state = mutableStateOf<PropT?>(null)
        //registeredStateProviders[property] = state

        stateSavers[property] = { model: ModelT ->
            Log.i(TAG, "Saving state \"${state.value}\" to property ${property.name}")
            property.set(model, state.value as PropT?)
        }

        stateUpdaters[property] = { model: ModelT ->
            val value = property.get(model)
            Log.i(TAG, "Loading state \"$value\" from property ${property.name}")
            state.value = value
        }

        return state
    }

    fun <PropT, SubPropT> stateOf(property: KMutableProperty1<ModelT, PropT>, subProp: KMutableProperty1<PropT, SubPropT?>): MutableState<SubPropT?> {
        val state = mutableStateOf<SubPropT?>(null)

        stateSavers[subProp] = { model: ModelT ->
            val subModel: PropT = property.get(model)
            Log.i(TAG, "Saving state \"${state.value}\" to property ${property.name}.${subProp.name}")
            subProp.set(subModel, state.value)
        }

        stateUpdaters[subProp] = { model: ModelT ->
            val subModel: PropT = property.get(model)
            val value = subProp.get(subModel)
            Log.i(TAG, "Loading state \"$value\" from property ${property.name}.${subProp.name}")
            state.value = value
        }

        return state
    }

    //fun getRegisteredStatePairs(model: ModelT) = properties.associateWith { prop -> registeredStateProviders[prop] }

    fun saveStatesToModel(model: ModelT) {
        Log.i(TAG, "Saving state to model")
        stateSavers.forEach { (_, saver) ->
            saver(model)
        }
    }

    fun loadStatesFromModel(model: ModelT) {
        Log.i(TAG, "Loading state from model")
        stateUpdaters.forEach { (_, updater) ->
            updater(model)
        }
    }
}

open class MutableStateProviderFromModel<ModelT : Any>(
    kClass: KClass<ModelT>,
    initialValue: ModelT
) : MutableStateProviderFor<ModelT>(kClass) {

    private var internalModel: ModelT = initialValue

    var model: ModelT
        get() {
            saveStatesToModel()
            return internalModel
        }
        set(value) {
            internalModel = value
            loadStatesFromModel()
        }

    fun saveStatesToModel() = saveStatesToModel(internalModel)
    fun loadStatesFromModel() = loadStatesFromModel(internalModel)
}

class ContactReasonData(model: ContactReasonDto) :
    MutableStateProviderFromModel<ContactReasonDto>(ContactReasonDto::class, model) {

    var activeStandbyDuty by stateOf(ContactReasonDto::activeStandbyDuty)

    var otherNotesState: MutableState<String?> = stateOf(ContactReasonDto::otherNotes)
    var otherNotes by otherNotesState



}


@Composable
fun Test() {

    val crd = ContactReasonData(ContactReasonDto())

    val state by crd.stateOf(ContactReasonDto::otherNotes)

}