package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains full information about a supergroup or channel
 *
 * @property description Supergroup or channel description
 * @property memberCount Number of members in the supergroup or channel
 *                       0 if unknown
 * @property administratorCount Number of privileged users in the supergroup or channel
 *                              0 if unknown
 * @property restrictedCount Number of restricted users in the supergroup
 *                           0 if unknown
 * @property bannedCount Number of users banned from chat
 *                       0 if unknown
 * @property linkedChatId Chat identifier of a discussion group for the channel, or a channel, for which the supergroup is the designated discussion group
 *                        0 if none or unknown
 * @property slowModeDelay Delay between consecutive sent messages for non-administrator supergroup members, in seconds
 * @property slowModeDelayExpiresIn Time left before next message can be sent in the supergroup, in seconds
 *                                  An updateSupergroupFullInfo update is not triggered when value of this field changes, but both new and old values are non-zero
 * @property canGetMembers True, if members of the chat can be retrieved
 * @property canSetUsername True, if the chat username can be changed
 * @property canSetStickerSet True, if the supergroup sticker set can be changed
 * @property canSetLocation True, if the supergroup location can be changed
 * @property canViewStatistics True, if the channel statistics is available through getChatStatisticsUrl
 * @property isAllHistoryAvailable True, if new chat members will have access to old messages
 *                                 In public or discussion groups and both public and private channels, old messages are always available, so this option affects only private supergroups without a linked chat
 *                                 The value of this field is only available for chat administrators
 * @property stickerSetId Identifier of the supergroup sticker set
 *                        0 if none
 * @property location Location to which the supergroup is connected
 * @property inviteLink Invite link for this chat
 * @property upgradedFromBasicGroupId Identifier of the basic group from which supergroup was upgraded
 *                                    0 if none
 * @property upgradedFromMaxMessageId Identifier of the last message in the basic group from which supergroup was upgraded
 *                                    0 if none
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("supergroupFullInfo")
data class TdSupergroupFullInfo(
    @SerialName("description")
    val description: String,
    @SerialName("member_count")
    val memberCount: Int,
    @SerialName("administrator_count")
    val administratorCount: Int,
    @SerialName("restricted_count")
    val restrictedCount: Int,
    @SerialName("banned_count")
    val bannedCount: Int,
    @SerialName("linked_chat_id")
    val linkedChatId: Long,
    @SerialName("slow_mode_delay")
    val slowModeDelay: Int,
    @SerialName("slow_mode_delay_expires_in")
    val slowModeDelayExpiresIn: Double,
    @SerialName("can_get_members")
    val canGetMembers: Boolean,
    @SerialName("can_set_username")
    val canSetUsername: Boolean,
    @SerialName("can_set_sticker_set")
    val canSetStickerSet: Boolean,
    @SerialName("can_set_location")
    val canSetLocation: Boolean,
    @SerialName("can_view_statistics")
    val canViewStatistics: Boolean,
    @SerialName("is_all_history_available")
    val isAllHistoryAvailable: Boolean,
    @SerialName("sticker_set_id")
    val stickerSetId: Long,
    @SerialName("location")
    val location: TdChatLocation?,
    @SerialName("invite_link")
    val inviteLink: String,
    @SerialName("upgraded_from_basic_group_id")
    val upgradedFromBasicGroupId: Int,
    @SerialName("upgraded_from_max_message_id")
    val upgradedFromMaxMessageId: Long,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
