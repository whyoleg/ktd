package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Specifies the kind of chat members to return in searchChatMembers
 */
@Serializable
sealed class TdChatMembersFilter : TdObject {
    /**
     * Returns contacts of the user
     */
    @Serializable
    @SerialName("chatMembersFilterContacts")
    object Contacts : TdChatMembersFilter()

    /**
     * Returns the owner and administrators
     */
    @Serializable
    @SerialName("chatMembersFilterAdministrators")
    object Administrators : TdChatMembersFilter()

    /**
     * Returns all chat members, including restricted chat members
     */
    @Serializable
    @SerialName("chatMembersFilterMembers")
    object Members : TdChatMembersFilter()

    /**
     * Returns users under certain restrictions in the chat
     * Can be used only by administrators in a supergroup
     */
    @Serializable
    @SerialName("chatMembersFilterRestricted")
    object Restricted : TdChatMembersFilter()

    /**
     * Returns users banned from the chat
     * Can be used only by administrators in a supergroup or in a channel
     */
    @Serializable
    @SerialName("chatMembersFilterBanned")
    object Banned : TdChatMembersFilter()

    /**
     * Returns bot members of the chat
     */
    @Serializable
    @SerialName("chatMembersFilterBots")
    object Bots : TdChatMembersFilter()
}
