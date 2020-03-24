package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks whether the current session can be used to transfer a chat ownership to another user
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.canTransferOwnership(extra: TdExtra = TdExtra.EMPTY):
        TdCanTransferOwnershipResult = exec(TdCanTransferOwnership(extra))
