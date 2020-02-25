package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the current secret chat state
 */
@Serializable
sealed class TdSecretChatState : TdObject {
    /**
     * The secret chat is not yet created
     * Waiting for the other user to get online
     */
    @Serializable
    @SerialName("secretChatStatePending")
    object Pending : TdSecretChatState()

    /**
     * The secret chat is ready to use
     */
    @Serializable
    @SerialName("secretChatStateReady")
    object Ready : TdSecretChatState()

    /**
     * The secret chat is closed
     */
    @Serializable
    @SerialName("secretChatStateClosed")
    object Closed : TdSecretChatState()
}
