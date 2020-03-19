package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A list of privacy rules
 * Rules are matched in the specified order
 * The first matched rule defines the privacy setting for a given user
 * If no rule matches, the action is not allowed
 *
 * @property rules A list of rules
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("userPrivacySettingRules")
data class TdUserPrivacySettingRules(
    @SerialName("rules")
    val rules: List<TdUserPrivacySettingRule>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
