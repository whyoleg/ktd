package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains full information about a user (except the full list of profile photos)
 *
 * @property isBlocked True, if the user is blacklisted by the current user
 * @property canBeCalled True, if the user can be called
 * @property hasPrivateCalls True, if the user can't be called due to their privacy settings
 * @property needPhoneNumberPrivacyException True, if the current user needs to explicitly allow to share their phone number with the user when the method addContact is used
 * @property bio A short user bio
 * @property shareText For bots, the text that is included with the link when users share the bot
 * @property groupInCommonCount Number of group chats where both the other user and the current user are a member
 *                              0 for the current user
 * @property botInfo If the user is a bot, information about the bot
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("userFullInfo")
data class TdUserFullInfo(
    @SerialName("is_blocked")
    val isBlocked: Boolean,
    @SerialName("can_be_called")
    val canBeCalled: Boolean,
    @SerialName("has_private_calls")
    val hasPrivateCalls: Boolean,
    @SerialName("need_phone_number_privacy_exception")
    val needPhoneNumberPrivacyException: Boolean,
    @SerialName("bio")
    val bio: String,
    @SerialName("share_text")
    val shareText: String,
    @SerialName("group_in_common_count")
    val groupInCommonCount: Int,
    @SerialName("bot_info")
    val botInfo: TdBotInfo?,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
