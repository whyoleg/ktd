package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the exact type of a problem with a call
 */
@Serializable
sealed class TdCallProblem : TdObject {
    /**
     * The user heard their own voice
     */
    @Serializable
    @SerialName("callProblemEcho")
    object Echo : TdCallProblem()

    /**
     * The user heard background noise
     */
    @Serializable
    @SerialName("callProblemNoise")
    object Noise : TdCallProblem()

    /**
     * The other side kept disappearing
     */
    @Serializable
    @SerialName("callProblemInterruptions")
    object Interruptions : TdCallProblem()

    /**
     * The speech was distorted
     */
    @Serializable
    @SerialName("callProblemDistortedSpeech")
    object DistortedSpeech : TdCallProblem()

    /**
     * The user couldn't hear the other side
     */
    @Serializable
    @SerialName("callProblemSilentLocal")
    object SilentLocal : TdCallProblem()

    /**
     * The other side couldn't hear the user
     */
    @Serializable
    @SerialName("callProblemSilentRemote")
    object SilentRemote : TdCallProblem()

    /**
     * The call ended unexpectedly
     */
    @Serializable
    @SerialName("callProblemDropped")
    object Dropped : TdCallProblem()
}
