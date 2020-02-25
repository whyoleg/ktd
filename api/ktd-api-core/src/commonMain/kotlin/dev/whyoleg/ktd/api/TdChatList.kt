package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a list of chats
 */
@Serializable
sealed class TdChatList : TdObject {
    /**
     * A main list of chats
     */
    @Serializable
    @SerialName("chatListMain")
    object Main : TdChatList()

    /**
     * A list of chats usually located at the top of the main chat list
     * Unmuted chats are automatically moved from the Archive to the Main chat list when a new message arrives
     */
    @Serializable
    @SerialName("chatListArchive")
    object Archive : TdChatList()
}
