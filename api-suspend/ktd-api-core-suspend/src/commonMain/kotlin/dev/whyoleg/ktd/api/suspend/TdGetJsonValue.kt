package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Converts a JSON-serialized string to corresponding JsonValue object
 * This is an offline method
 * Can be called before authorization
 *
 * @property json The JSON-serialized string
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getJsonValue(json: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdJsonValue = exec(TdGetJsonValue(json, extra))
