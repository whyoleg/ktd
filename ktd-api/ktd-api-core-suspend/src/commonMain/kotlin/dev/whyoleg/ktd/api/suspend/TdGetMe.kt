package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the current user
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getMe(extra: TdExtra = TdExtra.EMPTY): TdUser = exec(TdGetMe(extra))
