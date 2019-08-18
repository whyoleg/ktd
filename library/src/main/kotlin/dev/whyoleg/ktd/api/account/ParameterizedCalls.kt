@file:Suppress("unused")

package dev.whyoleg.ktd.api.account

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the period of inactivity after which the account of the current user will automatically be deleted
 *
 * @ttl - New account TTL
 */
suspend fun TelegramClient.setAccountTtl(
    ttl: AccountTtl
): Ok = account(
    SetAccountTtl(
        ttl
    )
)

/**
 * Returns the period of inactivity after which the account of the current user will automatically be deleted
 */
suspend fun TelegramClient.getAccountTtl(): AccountTtl = account(
    GetAccountTtl()
)

/**
 * Deletes the account of the current user, deleting all information associated with the user from the server. The phone number of the account can be used to create a new account. Can be called before authorization when the current authorization state is authorizationStateWaitPassword
 *
 * @reason - The reason why the account was deleted; optional
 */
suspend fun TelegramClient.deleteAccount(
    reason: String
): Ok = account(
    DeleteAccount(
        reason
    )
)
