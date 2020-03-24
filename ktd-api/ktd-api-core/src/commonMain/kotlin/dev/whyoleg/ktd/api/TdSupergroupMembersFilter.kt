package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Specifies the kind of chat members to return in getSupergroupMembers
 */
@Serializable
sealed class TdSupergroupMembersFilter : TdObject {
    /**
     * Returns recently active users in reverse chronological order
     */
    @Serializable
    @SerialName("supergroupMembersFilterRecent")
    object Recent : TdSupergroupMembersFilter()

    /**
     * Returns contacts of the user, which are members of the supergroup or channel
     *
     * @property query Query to search for
     */
    @Serializable
    @SerialName("supergroupMembersFilterContacts")
    data class Contacts(
        @SerialName("query")
        val query: String
    ) : TdSupergroupMembersFilter()

    /**
     * Returns the owner and administrators
     */
    @Serializable
    @SerialName("supergroupMembersFilterAdministrators")
    object Administrators : TdSupergroupMembersFilter()

    /**
     * Used to search for supergroup or channel members via a (string) query
     *
     * @property query Query to search for
     */
    @Serializable
    @SerialName("supergroupMembersFilterSearch")
    data class Search(
        @SerialName("query")
        val query: String
    ) : TdSupergroupMembersFilter()

    /**
     * Returns restricted supergroup members
     * Can be used only by administrators
     *
     * @property query Query to search for
     */
    @Serializable
    @SerialName("supergroupMembersFilterRestricted")
    data class Restricted(
        @SerialName("query")
        val query: String
    ) : TdSupergroupMembersFilter()

    /**
     * Returns users banned from the supergroup or channel
     * Can be used only by administrators
     *
     * @property query Query to search for
     */
    @Serializable
    @SerialName("supergroupMembersFilterBanned")
    data class Banned(
        @SerialName("query")
        val query: String
    ) : TdSupergroupMembersFilter()

    /**
     * Returns bot members of the supergroup or channel
     */
    @Serializable
    @SerialName("supergroupMembersFilterBots")
    object Bots : TdSupergroupMembersFilter()
}
