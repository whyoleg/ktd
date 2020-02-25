package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Changes the username of a supergroup or channel, requires owner privileges in the supergroup or channel
 *
 * @property supergroupId Identifier of the supergroup or channel
 * @property username New value of the username
 *                    Use an empty string to remove the username
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setSupergroupUsername(
    supergroupId: Int = 0,
    username: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetSupergroupUsername(supergroupId, username, extra))
