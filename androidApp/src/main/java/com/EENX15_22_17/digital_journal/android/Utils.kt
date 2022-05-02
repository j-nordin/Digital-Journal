package com.EENX15_22_17.digital_journal.android

object Utils {
    val Any.instanceReferenceString: String
        get() = Integer.toHexString(System.identityHashCode(this))
}