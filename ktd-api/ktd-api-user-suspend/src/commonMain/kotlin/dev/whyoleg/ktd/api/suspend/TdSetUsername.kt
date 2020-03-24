package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the username of the current user
 * If something changes, updateUser will be sent
 *
 * @property username The new value of the username
 *                    Use an empty string to remove the username
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setUsername(username: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdSetUsername(username, extra))
