package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns all available Telegram Passport elements
 *
 * @property password Password of the current user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getAllPassportElements(password: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdPassportElements = exec(TdGetAllPassportElements(password, extra))
