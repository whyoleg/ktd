package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes actions that a user is allowed to take in a chat
 *
 * @property canSendMessages True, if the user can send text messages, contacts, locations, and venues
 * @property canSendMediaMessages True, if the user can send audio files, documents, photos, videos, video notes, and voice notes
 *                                Implies can_send_messages permissions
 * @property canSendPolls True, if the user can send polls
 *                        Implies can_send_messages permissions
 * @property canSendOtherMessages True, if the user can send animations, games, and stickers and use inline bots
 *                                Implies can_send_messages permissions
 * @property canAddWebPagePreviews True, if the user may add a web page preview to their messages
 *                                 Implies can_send_messages permissions
 * @property canChangeInfo True, if the user can change the chat title, photo, and other settings
 * @property canInviteUsers True, if the user can invite new users to the chat
 * @property canPinMessages True, if the user can pin messages
 */
@Serializable
@SerialName("chatPermissions")
data class TdChatPermissions(
    @SerialName("can_send_messages")
    val canSendMessages: Boolean,
    @SerialName("can_send_media_messages")
    val canSendMediaMessages: Boolean,
    @SerialName("can_send_polls")
    val canSendPolls: Boolean,
    @SerialName("can_send_other_messages")
    val canSendOtherMessages: Boolean,
    @SerialName("can_add_web_page_previews")
    val canAddWebPagePreviews: Boolean,
    @SerialName("can_change_info")
    val canChangeInfo: Boolean,
    @SerialName("can_invite_users")
    val canInviteUsers: Boolean,
    @SerialName("can_pin_messages")
    val canPinMessages: Boolean
) : TdObject
