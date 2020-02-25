package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Shares the phone number of the current user with a mutual contact
 * Supposed to be called when the user clicks on chatActionBarSharePhoneNumber
 *
 * @property userId Identifier of the user with whom to share the phone number
 *                  The user must be a mutual contact
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sharePhoneNumber(userId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdOk
        = exec(TdSharePhoneNumber(userId, extra))
