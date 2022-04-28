package com.EENX15_22_17.digital_journal.android.screens.journal.arrival.hazardAssessment


data class HazardDataClass(
    var initialAssessment: Set<DangerType>,
    var specifiedBehavior: Set<DangerBehaviors>,
    var takenActions: String,
    var law: Set<Law>,
    var arrivalMethod: Set<ArrivalMethod>
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

enum class Law {
    HSL,
    LPT,
    FORTYSEVEN,
    VI,
    LRV,
    LVM,
    UNKNOWN
}

val laws = mapOf<Law, String>(
    Law.HSL to "HSL",
    Law.LPT to "LPT",
    Law.FORTYSEVEN to "$ 47",
    Law.VI to "VI",
    Law.LRV to "LRV",
    Law.LVM to "LVM",
)

enum class ArrivalMethod {
    OWN_INITIATIVE,
    RELATIVE,
    REMISS,
    MEDICINE,
    ALONE,
    AMBULANCE,
    POLICE,
    OTHER,
    UNKNOWN
}

val arrivalMethods = mapOf<ArrivalMethod, String>(
    ArrivalMethod.OWN_INITIATIVE to "Eget intiativ",
    ArrivalMethod.RELATIVE to "Med Anhörig",
    ArrivalMethod.REMISS to "Med Remiss",
    ArrivalMethod.MEDICINE to "Från Medicininstag",
    ArrivalMethod.ALONE to "Ensam",
    ArrivalMethod.AMBULANCE to "Med Ambulans",
    ArrivalMethod.POLICE to "Med Polis",
    ArrivalMethod.OTHER to "Annat"
)
