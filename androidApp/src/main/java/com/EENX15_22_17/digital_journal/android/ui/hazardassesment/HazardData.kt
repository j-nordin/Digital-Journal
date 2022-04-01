package com.EENX15_22_17.digital_journal.android.ui.hazardassesment


import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalMethod
import java.util.*


data class HazardDataClass(
    val initialAssessment: List<String>,
    val specifiedBehavior: List<String>,
    val takenActions: String
)

enum class DangerType {
    NOT_AGRESSIVE,
    PREVIOUSLY_AGRESSIVE,
    DRUG_AFFECTED
}

enum class DangerBehaviors {
    CONFUSED_BEHAVIOUR,
    IRRITATED_BEHAVIOUR,
    GRUMPY_BEHAVIOUR,
    PHYSICALLY_THREATENING,
    VERBALLY_THREATENING,
    ATTACKING_BEHAVIOUR
}

val dangerTypes = mapOf<DangerType, String>(
    DangerType.NOT_AGRESSIVE to "Ej förekomst av farligt beteende",
    DangerType.PREVIOUSLY_AGRESSIVE to "Tidigare våldsam",
    DangerType.DRUG_AFFECTED to "Verkar drogpåverkad"
    )

val dangerBehaviors = mapOf<DangerBehaviors, String>(
    DangerBehaviors.ATTACKING_BEHAVIOUR to "Attackerar föremål",
    DangerBehaviors.CONFUSED_BEHAVIOUR to "Förvirrat beteende",
    DangerBehaviors.IRRITATED_BEHAVIOUR to "Retligt/lättirriterat beteende",
    DangerBehaviors.GRUMPY_BEHAVIOUR to "Bullrigt beteende",
    DangerBehaviors.PHYSICALLY_THREATENING to "Fysiskt våldsamt beteende",
    DangerBehaviors.VERBALLY_THREATENING to "Verbalt hotfullt beteende"
)
