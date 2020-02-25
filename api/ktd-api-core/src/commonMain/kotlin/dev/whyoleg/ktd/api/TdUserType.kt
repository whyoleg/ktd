package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the type of a user
 * The following types are possible: regular users, deleted users and bots
 */
@Serializable
sealed class TdUserType : TdObject {
    /**
     * A regular user
     */
    @Serializable
    @SerialName("userTypeRegular")
    object Regular : TdUserType()

    /**
     * A deleted user or deleted bot
     * No information on the user besides the user identifier is available
     * It is not possible to perform any active actions on this type of user
     */
    @Serializable
    @SerialName("userTypeDeleted")
    object Deleted : TdUserType()

    /**
     * A bot (see https://core.telegram.org/bots)
     *
     * @property canJoinGroups True, if the bot can be invited to basic group and supergroup chats
     * @property canReadAllGroupMessages True, if the bot can read all messages in basic group or supergroup chats and not just those addressed to the bot
     *                                   In private and channel chats a bot can always read all messages
     * @property isInline True, if the bot supports inline queries
     * @property inlineQueryPlaceholder Placeholder for inline queries (displayed on the client input field)
     * @property needLocation True, if the location of the user should be sent with every inline query to this bot
     */
    @Serializable
    @SerialName("userTypeBot")
    data class Bot(
        @SerialName("can_join_groups")
        val canJoinGroups: Boolean,
        @SerialName("can_read_all_group_messages")
        val canReadAllGroupMessages: Boolean,
        @SerialName("is_inline")
        val isInline: Boolean,
        @SerialName("inline_query_placeholder")
        val inlineQueryPlaceholder: String,
        @SerialName("need_location")
        val needLocation: Boolean
    ) : TdUserType()

    /**
     * No information on the user besides the user identifier is available, yet this user has not been deleted
     * This object is extremely rare and must be handled like a deleted user
     * It is not possible to perform any actions on users of this type
     */
    @Serializable
    @SerialName("userTypeUnknown")
    object Unknown : TdUserType()
}
