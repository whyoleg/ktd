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
 * Sends a call rating
 */
suspend fun TelegramClient.call(
    f: SendCallRating
): Ok = exec(f) as Ok
