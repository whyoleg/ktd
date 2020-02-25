package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes a supergroup or channel along with all messages in the corresponding chat
 * This will release the supergroup or channel username and remove all members
 * Requires owner privileges in the supergroup or channel
 * Chats with more than 1000 members can't be deleted using this method
 *
 * @property supergroupId Identifier of the supergroup or channel
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteSupergroup(supergroupId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdDeleteSupergroup(supergroupId, extra))
