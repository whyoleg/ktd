package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the current call state
 */
@Serializable
sealed class TdCallState : TdObject {
    /**
     * The call is pending, waiting to be accepted by a user
     *
     * @property isCreated True, if the call has already been created by the server
     * @property isReceived True, if the call has already been received by the other party
     */
    @Serializable
    @SerialName("callStatePending")
    data class Pending(
        @SerialName("is_created")
        val isCreated: Boolean,
        @SerialName("is_received")
        val isReceived: Boolean
    ) : TdCallState()

    /**
     * The call has been answered and encryption keys are being exchanged
     */
    @Serializable
    @SerialName("callStateExchangingKeys")
    object ExchangingKeys : TdCallState()

    /**
     * The call is ready to use
     *
     * @property protocol Call protocols supported by the peer
     * @property connections Available UDP reflectors
     * @property config A JSON-encoded call config
     * @property encryptionKey Call encryption key
     * @property emojis Encryption key emojis fingerprint
     * @property allowP2p True, if peer-to-peer connection is allowed by users privacy settings
     */
    @Serializable
    @SerialName("callStateReady")
    data class Ready(
        @SerialName("protocol")
        val protocol: TdCallProtocol,
        @SerialName("connections")
        val connections: List<TdCallConnection>,
        @SerialName("config")
        val config: String,
        @SerialName("encryption_key")
        val encryptionKey: ByteArray,
        @SerialName("emojis")
        val emojis: List<String>,
        @SerialName("allow_p2p")
        val allowP2p: Boolean
    ) : TdCallState()

    /**
     * The call is hanging up after discardCall has been called
     */
    @Serializable
    @SerialName("callStateHangingUp")
    object HangingUp : TdCallState()

    /**
     * The call has ended successfully
     *
     * @property reason The reason, why the call has ended
     * @property needRating True, if the call rating should be sent to the server
     * @property needDebugInformation True, if the call debug information should be sent to the server
     */
    @Serializable
    @SerialName("callStateDiscarded")
    data class Discarded(
        @SerialName("reason")
        val reason: TdCallDiscardReason,
        @SerialName("need_rating")
        val needRating: Boolean,
        @SerialName("need_debug_information")
        val needDebugInformation: Boolean
    ) : TdCallState()

    /**
     * The call has ended with an error
     *
     * @property error Error
     *                 An error with the code 4005000 will be returned if an outgoing call is missed because of an expired timeout
     */
    @Serializable
    @SerialName("callStateError")
    data class Error(
        @SerialName("error")
        val error: TdError
    ) : TdCallState()
}
