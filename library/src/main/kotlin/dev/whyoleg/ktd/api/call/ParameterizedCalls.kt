@file:Suppress("unused")

package dev.whyoleg.ktd.api.call

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Creates a new call
 *
 * @userId - Identifier of the user to be called
 * @protocol - Description of the call protocols supported by the client
 */
suspend fun TelegramClient.createCall(
    userId: Int,
    protocol: CallProtocol
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
    callId: Int,
    protocol: CallProtocol
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
    callId: Int,
    isDisconnected: Boolean,
    duration: Int,
    connectionId: Long
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
 * @rating - Call rating; 1-5
 * @comment - An optional user comment if the rating is less than 5
 * @problems - List of the exact types of problems with the call, specified by the user
 */
suspend fun TelegramClient.sendCallRating(
    callId: Int,
    rating: Int,
    comment: String,
    problems: Array<CallProblem>
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
    callId: Int,
    debugInformation: String
): Ok = call(
    SendCallDebugInformation(
        callId,
        debugInformation
    )
)
