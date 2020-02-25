package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the categories of chats for which a list of frequently used chats can be retrieved
 */
@Serializable
sealed class TdTopChatCategory : TdObject {
    /**
     * A category containing frequently used private chats with non-bot users
     */
    @Serializable
    @SerialName("topChatCategoryUsers")
    object Users : TdTopChatCategory()

    /**
     * A category containing frequently used private chats with bot users
     */
    @Serializable
    @SerialName("topChatCategoryBots")
    object Bots : TdTopChatCategory()

    /**
     * A category containing frequently used basic groups and supergroups
     */
    @Serializable
    @SerialName("topChatCategoryGroups")
    object Groups : TdTopChatCategory()

    /**
     * A category containing frequently used channels
     */
    @Serializable
    @SerialName("topChatCategoryChannels")
    object Channels : TdTopChatCategory()

    /**
     * A category containing frequently used chats with inline bots sorted by their usage in inline mode
     */
    @Serializable
    @SerialName("topChatCategoryInlineBots")
    object InlineBots : TdTopChatCategory()

    /**
     * A category containing frequently used chats used for calls
     */
    @Serializable
    @SerialName("topChatCategoryCalls")
    object Calls : TdTopChatCategory()

    /**
     * A category containing frequently used chats used to forward messages
     */
    @Serializable
    @SerialName("topChatCategoryForwardChats")
    object ForwardChats : TdTopChatCategory()
}
