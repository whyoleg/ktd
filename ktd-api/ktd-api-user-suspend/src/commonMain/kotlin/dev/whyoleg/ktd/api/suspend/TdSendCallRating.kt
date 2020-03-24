package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a call rating
 *
 * @property callId Call identifier
 * @property rating Call rating
 * @property comment An optional user comment if the rating is less than 5
 * @property problems List of the exact types of problems with the call, specified by the user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendCallRating(
    callId: Int = 0,
    rating: Int = 0,
    comment: String? = null,
    problems: List<TdCallProblem> = emptyList(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSendCallRating(callId, rating, comment, problems, extra))
