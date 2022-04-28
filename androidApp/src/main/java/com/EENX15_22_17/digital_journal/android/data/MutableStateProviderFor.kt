package com.EENX15_22_17.digital_journal.android.data

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1

/**
 * Helper class which given a [ModelT] can create [MutableState] objects based on its properties.
 *
 * This is done by providing property references to the [stateOf]-methods. For example:
 *
 * ```kotlin
 * var stateProvider = MutableStateProviderFor<UserModel>()
 * var userName by stateProvider.stateOf(UserModel::userName)
 * ```
 *
 * The created [MutableState]s are managed by the class, enabling it to save or load the state
 * values into a [ModelT] instance using [saveStatesToModel] and [loadStatesFromModel].
 *
 * ```kotlin
 * var userModel = UserModel()
 * stateProvider.saveStatesToModel(userModel)
 * api.saveUser(userModel)
 * ```
 */
open class MutableStateProviderFor<ModelT : Any> {
    private val TAG = "MutableStateProviderFor"

    private val stateHolders: MutableMap<KProperty1<*, *>, MutableState<*>> = mutableMapOf()
    private val stateSavers: MutableMap<KProperty1<*, *>, ((ModelT) -> Unit)> = mutableMapOf()
    private val stateLoaders: MutableMap<KProperty1<*, *>, ((ModelT) -> Unit)> =
        mutableMapOf()

    /**
     * Creates a [MutableState] based on the provided [property]
     */
    fun <PropT> stateOf(property: KMutableProperty1<ModelT, PropT?>): MutableState<PropT?> {
        return stateHolders.getOrPut(property) {
            val state = mutableStateOf<PropT?>(null)

            stateSavers[property] = { model: ModelT ->
                Log.d(TAG, "Saving state \"${state.value}\" to property ${property.name}")
                property.set(model, state.value)
            }

            stateLoaders[property] = { model: ModelT ->
                val value = property.get(model)
                Log.d(TAG, "Loading state \"$value\" from property ${property.name}")
                state.value = value
            }

            return@getOrPut state
        } as MutableState<PropT?>
    }

    /**
     * Creates a [MutableState] based on the provided [subProp] of [property]
     */
    fun <PropT, SubPropT> stateOf(
        property: KMutableProperty1<ModelT, PropT>,
        subProp: KMutableProperty1<PropT, SubPropT?>
    ): MutableState<SubPropT?> {
        return stateHolders.getOrPut(subProp) {
            val state = mutableStateOf<SubPropT?>(null)

            stateSavers[subProp] = { model: ModelT ->
                val subModel: PropT = property.get(model)
                Log.d(
                    TAG,
                    "Saving state \"${state.value}\" to property ${property.name}.${subProp.name}"
                )
                subProp.set(subModel, state.value)
            }

            stateLoaders[subProp] = { model: ModelT ->
                val subModel: PropT = property.get(model)
                val value = subProp.get(subModel)
                Log.d(
                    TAG,
                    "Loading state \"$value\" from property ${property.name}.${subProp.name}"
                )
                state.value = value
            }

            return@getOrPut state
        } as MutableState<SubPropT?>
    }

    /**
     * Saves the states of all registered state-properties to the supplied [model] object.
     */
    fun saveStatesToModel(model: ModelT) {
        Log.i(TAG, "Saving state to model")
        stateSavers.forEach { (_, saver) ->
            saver(model)
        }
    }

    /**
     * Loads values from the supplied [model] object, setting the state of all registered
     * state-properties.
     */
    fun loadStatesFromModel(model: ModelT) {
        Log.i(TAG, "Loading state from model")
        stateLoaders.forEach { (_, updater) ->
            updater(model)
        }
    }
}