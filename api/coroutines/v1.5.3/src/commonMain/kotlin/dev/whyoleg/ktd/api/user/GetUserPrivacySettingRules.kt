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
 * Returns the current privacy settings
 *
 * @setting - The privacy setting
 */
suspend fun TelegramClient.getUserPrivacySettingRules(
    setting: UserPrivacySetting? = null
): UserPrivacySettingRules = user(
    GetUserPrivacySettingRules(
        setting
    )
)

/**
 * Returns the current privacy settings
 */
suspend fun TelegramClient.user(
    f: GetUserPrivacySettingRules
): UserPrivacySettingRules = exec(f) as UserPrivacySettingRules
