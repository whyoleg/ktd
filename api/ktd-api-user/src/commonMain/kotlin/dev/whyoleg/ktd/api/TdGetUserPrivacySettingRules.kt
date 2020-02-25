package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the current privacy settings
 *
 * @property setting The privacy setting
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getUserPrivacySettingRules")
data class TdGetUserPrivacySettingRules(
    @SerialName("setting")
    val setting: TdUserPrivacySetting? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUserPrivacySettingRules> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetUserPrivacySettingRules {
        return copy(extra = extra.copy(id = id))
    }
}
