package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Converts a JsonValue object to corresponding JSON-serialized string
 * This is an offline method
 * Can be called before authorization
 *
 * @property jsonValue The JsonValue object
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getJsonString(jsonValue: TdJsonValue? = null, extra: TdExtra =
        TdExtra.EMPTY): TdText = exec(TdGetJsonString(jsonValue, extra))
