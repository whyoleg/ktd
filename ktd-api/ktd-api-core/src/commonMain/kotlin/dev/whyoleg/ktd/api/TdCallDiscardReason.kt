package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the reason why a call was discarded
 */
@Serializable
sealed class TdCallDiscardReason : TdObject {
    /**
     * The call wasn't discarded, or the reason is unknown
     */
    @Serializable
    @SerialName("callDiscardReasonEmpty")
    object Empty : TdCallDiscardReason()

    /**
     * The call was ended before the conversation started
     * It was cancelled by the caller or missed by the other party
     */
    @Serializable
    @SerialName("callDiscardReasonMissed")
    object Missed : TdCallDiscardReason()

    /**
     * The call was ended before the conversation started
     * It was declined by the other party
     */
    @Serializable
    @SerialName("callDiscardReasonDeclined")
    object Declined : TdCallDiscardReason()

    /**
     * The call was ended during the conversation because the users were disconnected
     */
    @Serializable
    @SerialName("callDiscardReasonDisconnected")
    object Disconnected : TdCallDiscardReason()

    /**
     * The call was ended because one of the parties hung up
     */
    @Serializable
    @SerialName("callDiscardReasonHungUp")
    object HungUp : TdCallDiscardReason()
}
