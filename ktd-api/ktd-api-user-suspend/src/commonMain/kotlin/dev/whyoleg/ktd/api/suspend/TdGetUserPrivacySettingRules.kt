package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the current privacy settings
 *
 * @property setting The privacy setting
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getUserPrivacySettingRules(setting: TdUserPrivacySetting? = null,
        extra: TdExtra = TdExtra.EMPTY): TdUserPrivacySettingRules =
        exec(TdGetUserPrivacySettingRules(setting, extra))
