package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Informs the user that some of the elements in their Telegram Passport contain errors
 * The user will not be able to resend the elements, until the errors are fixed
 *
 * @property userId User identifier
 * @property errors The errors
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setPassportElementErrors(
    userId: Int = 0,
    errors: List<TdInputPassportElementError> = emptyList(),
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetPassportElementErrors(userId, errors, extra))
