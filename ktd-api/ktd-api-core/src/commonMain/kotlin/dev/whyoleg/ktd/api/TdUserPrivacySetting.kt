package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes available user privacy settings
 */
@Serializable
sealed class TdUserPrivacySetting : TdObject {
    /**
     * A privacy setting for managing whether the user's online status is visible
     */
    @Serializable
    @SerialName("userPrivacySettingShowStatus")
    object ShowStatus : TdUserPrivacySetting()

    /**
     * A privacy setting for managing whether the user's profile photo is visible
     */
    @Serializable
    @SerialName("userPrivacySettingShowProfilePhoto")
    object ShowProfilePhoto : TdUserPrivacySetting()

    /**
     * A privacy setting for managing whether a link to the user's account is included in forwarded messages
     */
    @Serializable
    @SerialName("userPrivacySettingShowLinkInForwardedMessages")
    object ShowLinkInForwardedMessages : TdUserPrivacySetting()

    /**
     * A privacy setting for managing whether the user's phone number is visible
     */
    @Serializable
    @SerialName("userPrivacySettingShowPhoneNumber")
    object ShowPhoneNumber : TdUserPrivacySetting()

    /**
     * A privacy setting for managing whether the user can be invited to chats
     */
    @Serializable
    @SerialName("userPrivacySettingAllowChatInvites")
    object AllowChatInvites : TdUserPrivacySetting()

    /**
     * A privacy setting for managing whether the user can be called
     */
    @Serializable
    @SerialName("userPrivacySettingAllowCalls")
    object AllowCalls : TdUserPrivacySetting()

    /**
     * A privacy setting for managing whether peer-to-peer connections can be used for calls
     */
    @Serializable
    @SerialName("userPrivacySettingAllowPeerToPeerCalls")
    object AllowPeerToPeerCalls : TdUserPrivacySetting()

    /**
     * A privacy setting for managing whether the user can be found by their phone number
     * Checked only if the phone number is not known to the other user
     * Can be set only to "Allow contacts" or "Allow all"
     */
    @Serializable
    @SerialName("userPrivacySettingAllowFindingByPhoneNumber")
    object AllowFindingByPhoneNumber : TdUserPrivacySetting()
}
