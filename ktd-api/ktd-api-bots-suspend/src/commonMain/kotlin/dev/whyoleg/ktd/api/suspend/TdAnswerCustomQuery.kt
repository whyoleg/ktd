package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Answers a custom query
 *
 * @property customQueryId Identifier of a custom query
 * @property data JSON-serialized answer to the query
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.answerCustomQuery(
    customQueryId: Long = 0L,
    data: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAnswerCustomQuery(customQueryId, data, extra))
