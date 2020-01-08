@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.account

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Deletes the account of the current user, deleting all information associated with the user from the server
 * The phone number of the account can be used to create a new account
 * Can be called before authorization when the current authorization state is authorizationStateWaitPassword
 *
 * @reason - The reason why the account was deleted
 */
suspend fun TelegramClient.deleteAccount(
    reason: String? = null
): Ok = account(
    DeleteAccount(
        reason
    )
)

/**
 * Deletes the account of the current user, deleting all information associated with the user from the server
 * The phone number of the account can be used to create a new account
 * Can be called before authorization when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.account(
    f: DeleteAccount
): Ok = exec(f) as Ok
