@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.group

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a basic group by its identifier
 * This is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.group(
    f: GetBasicGroup
): BasicGroup = exec(f) as BasicGroup

/**
 * Returns full information about a basic group by its identifier
 */
suspend fun TelegramClient.group(
    f: GetBasicGroupFullInfo
): BasicGroupFullInfo = exec(f) as BasicGroupFullInfo

/**
 * Toggles the "All members are admins" setting in basic groups
 * Requires creator privileges in the group
 */
suspend fun TelegramClient.group(
    f: ToggleBasicGroupAdministrators
): Ok = exec(f) as Ok
