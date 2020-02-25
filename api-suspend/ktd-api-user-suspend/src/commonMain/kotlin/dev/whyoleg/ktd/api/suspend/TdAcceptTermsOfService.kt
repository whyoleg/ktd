package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Accepts Telegram terms of services
 *
 * @property termsOfServiceId Terms of service identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.acceptTermsOfService(termsOfServiceId: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdAcceptTermsOfService(termsOfServiceId, extra))
