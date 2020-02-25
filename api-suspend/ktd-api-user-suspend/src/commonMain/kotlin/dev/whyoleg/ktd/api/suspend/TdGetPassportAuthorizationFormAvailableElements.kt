package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns already available Telegram Passport elements suitable for completing a Telegram Passport authorization form
 * Result can be received only once for each authorization form
 *
 * @property autorizationFormId Authorization form identifier
 * @property password Password of the current user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPassportAuthorizationFormAvailableElements(
    autorizationFormId: Int = 0,
    password: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdPassportElementsWithErrors =
        exec(TdGetPassportAuthorizationFormAvailableElements(autorizationFormId, password, extra))
