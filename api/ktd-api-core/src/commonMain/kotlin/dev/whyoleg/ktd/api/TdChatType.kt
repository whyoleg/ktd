package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the type of a chat
 */
@Serializable
sealed class TdChatType : TdObject {
    /**
     * An ordinary chat with a user
     *
     * @property userId User identifier
     */
    @Serializable
    @SerialName("chatTypePrivate")
    data class Private(
        @SerialName("user_id")
        val userId: Int
    ) : TdChatType()

    /**
     * A basic group (i.e., a chat with 0-200 other users)
     *
     * @property basicGroupId Basic group identifier
     */
    @Serializable
    @SerialName("chatTypeBasicGroup")
    data class BasicGroup(
        @SerialName("basic_group_id")
        val basicGroupId: Int
    ) : TdChatType()

    /**
     * A supergroup (i.e
     * A chat with up to GetOption("supergroup_max_size") other users), or channel (with unlimited members)
     *
     * @property supergroupId Supergroup or channel identifier
     * @property isChannel True, if the supergroup is a channel
     */
    @Serializable
    @SerialName("chatTypeSupergroup")
    data class Supergroup(
        @SerialName("supergroup_id")
        val supergroupId: Int,
        @SerialName("is_channel")
        val isChannel: Boolean
    ) : TdChatType()

    /**
     * A secret chat with a user
     *
     * @property secretChatId Secret chat identifier
     * @property userId User identifier of the secret chat peer
     */
    @Serializable
    @SerialName("chatTypeSecret")
    data class Secret(
        @SerialName("secret_chat_id")
        val secretChatId: Int,
        @SerialName("user_id")
        val userId: Int
    ) : TdChatType()
}
