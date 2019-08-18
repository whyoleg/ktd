@file:Suppress("unused")

package dev.whyoleg.ktd.api.account

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the period of inactivity after which the account of the current user will automatically be deleted
 */
suspend fun TelegramClient.account(
    f: SetAccountTtl
): Ok = execRaw(f) as Ok

/**
 * Returns the period of inactivity after which the account of the current user will automatically be deleted
 */
suspend fun TelegramClient.account(
    f: GetAccountTtl
): AccountTtl = execRaw(f) as AccountTtl

/**
 * Deletes the account of the current user, deleting all information associated with the user from the server. The phone number of the account can be used to create a new account. Can be called before authorization when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TelegramClient.account(
    f: DeleteAccount
): Ok = execRaw(f) as Ok
