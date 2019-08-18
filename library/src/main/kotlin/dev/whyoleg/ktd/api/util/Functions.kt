@file:Suppress("unused")

package dev.whyoleg.ktd.api.util

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sets the parameters for TDLib initialization. Works only when the current authorization state is authorizationStateWaitTdlibParameters
 */
suspend fun TelegramClient.util(
    f: SetTdlibParameters
): Ok = execRaw(f) as Ok

/**
 * Closes the TDLib instance. All databases will be flushed to disk and properly closed. After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.util(
    f: Close
): Ok = execRaw(f) as Ok

/**
 * Closes the TDLib instance, destroying all local data without a proper logout. The current user session will remain in the list of all active sessions. All local data will be destroyed. After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.util(
    f: Destroy
): Ok = execRaw(f) as Ok

/**
 * Sets the result of a shipping query; for bots only
 */
suspend fun TelegramClient.util(
    f: AnswerShippingQuery
): Ok = execRaw(f) as Ok

/**
 * Removes users from the contact list
 */
suspend fun TelegramClient.util(
    f: RemoveContacts
): Ok = execRaw(f) as Ok

/**
 * Removes a hashtag from the list of recently used hashtags
 */
suspend fun TelegramClient.util(
    f: RemoveRecentHashtag
): Ok = execRaw(f) as Ok

/**
 * Changes the first and last name of the current user. If something changes, updateUser will be sent
 */
suspend fun TelegramClient.util(
    f: SetName
): Ok = execRaw(f) as Ok

/**
 * Changes the bio of the current user
 */
suspend fun TelegramClient.util(
    f: SetBio
): Ok = execRaw(f) as Ok

/**
 * Terminates a session of the current user
 */
suspend fun TelegramClient.util(
    f: TerminateSession
): Ok = execRaw(f) as Ok

/**
 * Deletes saved credentials for all payment provider bots
 */
suspend fun TelegramClient.util(
    f: DeleteSavedCredentials
): Ok = execRaw(f) as Ok

/**
 * Accepts Telegram terms of services
 */
suspend fun TelegramClient.util(
    f: AcceptTermsOfService
): Ok = execRaw(f) as Ok

/**
 * Succeeds after a specified amount of time has passed. Can be called before authorization. Can be called before initialization
 */
suspend fun TelegramClient.util(
    f: SetAlarm
): Ok = execRaw(f) as Ok
