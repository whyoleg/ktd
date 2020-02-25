package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a set of filters used to obtain a chat event log
 *
 * @property messageEdits True, if message edits should be returned
 * @property messageDeletions True, if message deletions should be returned
 * @property messagePins True, if pin/unpin events should be returned
 * @property memberJoins True, if members joining events should be returned
 * @property memberLeaves True, if members leaving events should be returned
 * @property memberInvites True, if invited member events should be returned
 * @property memberPromotions True, if member promotion/demotion events should be returned
 * @property memberRestrictions True, if member restricted/unrestricted/banned/unbanned events should be returned
 * @property infoChanges True, if changes in chat information should be returned
 * @property settingChanges True, if changes in chat settings should be returned
 */
@Serializable
@SerialName("chatEventLogFilters")
data class TdChatEventLogFilters(
    @SerialName("message_edits")
    val messageEdits: Boolean,
    @SerialName("message_deletions")
    val messageDeletions: Boolean,
    @SerialName("message_pins")
    val messagePins: Boolean,
    @SerialName("member_joins")
    val memberJoins: Boolean,
    @SerialName("member_leaves")
    val memberLeaves: Boolean,
    @SerialName("member_invites")
    val memberInvites: Boolean,
    @SerialName("member_promotions")
    val memberPromotions: Boolean,
    @SerialName("member_restrictions")
    val memberRestrictions: Boolean,
    @SerialName("info_changes")
    val infoChanges: Boolean,
    @SerialName("setting_changes")
    val settingChanges: Boolean
) : TdObject
