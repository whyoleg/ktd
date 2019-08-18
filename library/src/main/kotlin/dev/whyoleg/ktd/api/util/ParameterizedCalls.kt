@file:Suppress("unused")

package dev.whyoleg.ktd.api.util

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sets the parameters for TDLib initialization. Works only when the current authorization state is authorizationStateWaitTdlibParameters
 *
 * @parameters - Parameters
 */
suspend fun TelegramClient.setTdlibParameters(
    parameters: TdlibParameters
): Ok = util(
    SetTdlibParameters(
        parameters
    )
)

/**
 * Closes the TDLib instance. All databases will be flushed to disk and properly closed. After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.close(): Ok = util(
    Close()
)

/**
 * Closes the TDLib instance, destroying all local data without a proper logout. The current user session will remain in the list of all active sessions. All local data will be destroyed. After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.destroy(): Ok = util(
    Destroy()
)

/**
 * Sets the result of a shipping query; for bots only
 *
 * @shippingQueryId - Identifier of the shipping query
 * @shippingOptions - Available shipping options
 * @errorMessage - An error message, empty on success
 */
suspend fun TelegramClient.answerShippingQuery(
    shippingQueryId: Long,
    shippingOptions: Array<ShippingOption>,
    errorMessage: String
): Ok = util(
    AnswerShippingQuery(
        shippingQueryId,
        shippingOptions,
        errorMessage
    )
)

/**
 * Removes users from the contact list
 *
 * @userIds - Identifiers of users to be deleted
 */
suspend fun TelegramClient.removeContacts(
    userIds: IntArray
): Ok = util(
    RemoveContacts(
        userIds
    )
)

/**
 * Removes a hashtag from the list of recently used hashtags
 *
 * @hashtag - Hashtag to delete
 */
suspend fun TelegramClient.removeRecentHashtag(
    hashtag: String
): Ok = util(
    RemoveRecentHashtag(
        hashtag
    )
)

/**
 * Changes the first and last name of the current user. If something changes, updateUser will be sent
 *
 * @firstName - The new value of the first name for the user; 1-64 characters
 * @lastName - The new value of the optional last name for the user; 0-64 characters
 */
suspend fun TelegramClient.setName(
    firstName: String,
    lastName: String
): Ok = util(
    SetName(
        firstName,
        lastName
    )
)

/**
 * Changes the bio of the current user
 *
 * @bio - The new value of the user bio; 0-70 characters without line feeds
 */
suspend fun TelegramClient.setBio(
    bio: String
): Ok = util(
    SetBio(
        bio
    )
)

/**
 * Terminates a session of the current user
 *
 * @sessionId - Session identifier
 */
suspend fun TelegramClient.terminateSession(
    sessionId: Long
): Ok = util(
    TerminateSession(
        sessionId
    )
)

/**
 * Deletes saved credentials for all payment provider bots
 */
suspend fun TelegramClient.deleteSavedCredentials(): Ok = util(
    DeleteSavedCredentials()
)

/**
 * Accepts Telegram terms of services
 *
 * @termsOfServiceId - Terms of service identifier
 */
suspend fun TelegramClient.acceptTermsOfService(
    termsOfServiceId: String
): Ok = util(
    AcceptTermsOfService(
        termsOfServiceId
    )
)

/**
 * Succeeds after a specified amount of time has passed. Can be called before authorization. Can be called before initialization
 *
 * @seconds - Number of seconds before the function returns
 */
suspend fun TelegramClient.setAlarm(
    seconds: Double
): Ok = util(
    SetAlarm(
        seconds
    )
)
