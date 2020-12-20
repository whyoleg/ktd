package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Succeeds after a specified amount of time has passed
 * Can be called before authorization
 * Can be called before initialization
 *
 * @property seconds Number of seconds before the function returns
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setAlarm(seconds: Double = 0.0, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdSetAlarm(seconds, extra))
