package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Creates a new temporary password for processing payments
 *
 * @property password Persistent user password
 * @property validFor Time during which the temporary password will be valid, in seconds
 *                    Should be between 60 and 86400
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.createTemporaryPassword(
    password: String? = null,
    validFor: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdTemporaryPasswordState = exec(TdCreateTemporaryPassword(password, validFor, extra))
