package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a type of public chats
 */
@Serializable
sealed class TdPublicChatType : TdObject {
    /**
     * The chat is public, because it has username
     */
    @Serializable
    @SerialName("publicChatTypeHasUsername")
    object HasUsername : TdPublicChatType()

    /**
     * The chat is public, because it is a location-based supergroup
     */
    @Serializable
    @SerialName("publicChatTypeIsLocationBased")
    object IsLocationBased : TdPublicChatType()
}
