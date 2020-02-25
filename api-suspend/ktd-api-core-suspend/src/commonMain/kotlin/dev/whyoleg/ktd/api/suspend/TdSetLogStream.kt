package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets new log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @property logStream New log stream
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setLogStream(logStream: TdLogStream? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdSetLogStream(logStream, extra))
