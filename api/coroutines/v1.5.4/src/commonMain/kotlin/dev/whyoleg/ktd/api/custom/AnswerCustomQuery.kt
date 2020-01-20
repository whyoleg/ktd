@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.custom

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Answers a custom query
 *
 * @customQueryId - Identifier of a custom query
 * @data - JSON-serialized answer to the query
 */
@BotsOnly
suspend fun TelegramClient.answerCustomQuery(
    customQueryId: Long = 0L,
    data: String? = null
): Ok = custom(
    AnswerCustomQuery(
        customQueryId,
        data
    )
)

/**
 * Answers a custom query
 */
@BotsOnly
suspend fun TelegramClient.custom(
    f: AnswerCustomQuery
): Ok = exec(f) as Ok
