package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes user privacy settings
 *
 * @property setting The privacy setting
 * @property rules The new privacy rules
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setUserPrivacySettingRules")
data class TdSetUserPrivacySettingRules(
    @SerialName("setting")
    val setting: TdUserPrivacySetting? = null,
    @SerialName("rules")
    val rules: TdUserPrivacySettingRules? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetUserPrivacySettingRules {
        return copy(extra = extra.copy(id = id))
    }
}
