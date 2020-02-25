package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Provides information about the status of a member in a chat
 */
@Serializable
sealed class TdChatMemberStatus : TdObject {
    /**
     * The user is the owner of a chat and has all the administrator privileges
     *
     * @property customTitle A custom title of the owner
     *                       Applicable to supergroups only
     * @property isMember True, if the user is a member of the chat
     */
    @Serializable
    @SerialName("chatMemberStatusCreator")
    data class Creator(
        @SerialName("custom_title")
        val customTitle: String,
        @SerialName("is_member")
        val isMember: Boolean
    ) : TdChatMemberStatus()

    /**
     * The user is a member of a chat and has some additional privileges
     * In basic groups, administrators can edit and delete messages sent by others, add new members, and ban unprivileged members
     * In supergroups and channels, there are more detailed options for administrator privileges
     *
     * @property customTitle A custom title of the administrator
     *                       Applicable to supergroups only
     * @property canBeEdited True, if the current user can edit the administrator privileges for the called user
     * @property canChangeInfo True, if the administrator can change the chat title, photo, and other settings
     * @property canPostMessages True, if the administrator can create channel posts
     *                           Applicable to channels only
     * @property canEditMessages True, if the administrator can edit messages of other users and pin messages
     *                           Applicable to channels only
     * @property canDeleteMessages True, if the administrator can delete messages of other users
     * @property canInviteUsers True, if the administrator can invite new users to the chat
     * @property canRestrictMembers True, if the administrator can restrict, ban, or unban chat members
     * @property canPinMessages True, if the administrator can pin messages
     *                          Applicable to groups only
     * @property canPromoteMembers True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that were directly or indirectly promoted by them
     */
    @Serializable
    @SerialName("chatMemberStatusAdministrator")
    data class Administrator(
        @SerialName("custom_title")
        val customTitle: String,
        @SerialName("can_be_edited")
        val canBeEdited: Boolean,
        @SerialName("can_change_info")
        val canChangeInfo: Boolean,
        @SerialName("can_post_messages")
        val canPostMessages: Boolean,
        @SerialName("can_edit_messages")
        val canEditMessages: Boolean,
        @SerialName("can_delete_messages")
        val canDeleteMessages: Boolean,
        @SerialName("can_invite_users")
        val canInviteUsers: Boolean,
        @SerialName("can_restrict_members")
        val canRestrictMembers: Boolean,
        @SerialName("can_pin_messages")
        val canPinMessages: Boolean,
        @SerialName("can_promote_members")
        val canPromoteMembers: Boolean
    ) : TdChatMemberStatus()

    /**
     * The user is a member of a chat, without any additional privileges or restrictions
     */
    @Serializable
    @SerialName("chatMemberStatusMember")
    object Member : TdChatMemberStatus()

    /**
     * The user is under certain restrictions in the chat
     * Not supported in basic groups and channels
     *
     * @property isMember True, if the user is a member of the chat
     * @property restrictedUntilDate Point in time (Unix timestamp) when restrictions will be lifted from the user
     *                               0 if never
     *                               If the user is restricted for more than 366 days or for less than 30 seconds from the current time, the user is considered to be restricted forever
     * @property permissions User permissions in the chat
     */
    @Serializable
    @SerialName("chatMemberStatusRestricted")
    data class Restricted(
        @SerialName("is_member")
        val isMember: Boolean,
        @SerialName("restricted_until_date")
        val restrictedUntilDate: Int,
        @SerialName("permissions")
        val permissions: TdChatPermissions
    ) : TdChatMemberStatus()

    /**
     * The user is not a chat member
     */
    @Serializable
    @SerialName("chatMemberStatusLeft")
    object Left : TdChatMemberStatus()

    /**
     * The user was banned (and hence is not a member of the chat)
     * Implies the user can't return to the chat or view messages
     *
     * @property bannedUntilDate Point in time (Unix timestamp) when the user will be unbanned
     *                           0 if never
     *                           If the user is banned for more than 366 days or for less than 30 seconds from the current time, the user is considered to be banned forever
     */
    @Serializable
    @SerialName("chatMemberStatusBanned")
    data class Banned(
        @SerialName("banned_until_date")
        val bannedUntilDate: Int
    ) : TdChatMemberStatus()
}
