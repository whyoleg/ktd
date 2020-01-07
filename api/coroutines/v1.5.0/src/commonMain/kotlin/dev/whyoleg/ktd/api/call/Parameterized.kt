@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.call

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Creates a new call
 *
 * @userId - Identifier of the user to be called
 * @protocol - Description of the call protocols supported by the client
 */
suspend fun TelegramClient.createCall(
    userId: Int = 0,
    protocol: CallProtocol? = null
): CallId = call(
    CreateCall(
        userId,
        protocol
    )
)

/**
 * Accepts an incoming call
 *
 * @callId - Call identifier
 * @protocol - Description of the call protocols supported by the client
 */
suspend fun TelegramClient.acceptCall(
    callId: Int = 0,
    protocol: CallProtocol? = null
): Ok = call(
    AcceptCall(
        callId,
        protocol
    )
)

/**
 * Discards a call
 *
 * @callId - Call identifier
 * @isDisconnected - True, if the user was disconnected
 * @duration - The call duration, in seconds
 * @connectionId - Identifier of the connection used during the call
 */
suspend fun TelegramClient.discardCall(
    callId: Int = 0,
    isDisconnected: Boolean = false,
    duration: Int = 0,
    connectionId: Long = 0L
): Ok = call(
    DiscardCall(
        callId,
        isDisconnected,
        duration,
        connectionId
    )
)

/**
 * Sends a call rating
 *
 * @callId - Call identifier
 * @rating - Call rating
 * @comment - An optional user comment if the rating is less than 5
 * @problems - List of the exact types of problems with the call, specified by the user
 */
suspend fun TelegramClient.sendCallRating(
    callId: Int = 0,
    rating: Int = 0,
    comment: String? = null,
    problems: Array<CallProblem> = emptyArray()
): Ok = call(
    SendCallRating(
        callId,
        rating,
        comment,
        problems
    )
)

/**
 * Sends debug information for a call
 *
 * @callId - Call identifier
 * @debugInformation - Debug information in application-specific format
 */
suspend fun TelegramClient.sendCallDebugInformation(
    callId: Int = 0,
    debugInformation: String? = null
): Ok = call(
    SendCallDebugInformation(
        callId,
        debugInformation
    )
)
