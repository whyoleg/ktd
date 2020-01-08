@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.log

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Closes the TDLib instance after a proper logout
 * Requires an available network connection
 * All local data will be destroyed
 * After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.logOut(): Ok = log(
    LogOut()
)

/**
 * Closes the TDLib instance after a proper logout
 * Requires an available network connection
 * All local data will be destroyed
 * After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.log(
    f: LogOut
): Ok = exec(f) as Ok
