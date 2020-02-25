package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes user privacy settings
 *
 * @property setting The privacy setting
 * @property rules The new privacy rules
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setUserPrivacySettingRules(
    setting: TdUserPrivacySetting? = null,
    rules: TdUserPrivacySettingRules? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetUserPrivacySettingRules(setting, rules, extra))
