@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes user privacy settings
 *
 * @setting - The privacy setting
 * @rules - The new privacy rules
 */
suspend fun TelegramClient.setUserPrivacySettingRules(
    setting: UserPrivacySetting? = null,
    rules: UserPrivacySettingRules? = null
): Ok = user(
    SetUserPrivacySettingRules(
        setting,
        rules
    )
)

/**
 * Changes user privacy settings
 */
suspend fun TelegramClient.user(
    f: SetUserPrivacySettingRules
): Ok = exec(f) as Ok
