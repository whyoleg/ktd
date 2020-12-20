package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Confirms QR code authentication on another device
 * Returns created session on success
 *
 * @property link A link from a QR code
 *                The link must be scanned by the in-app camera
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.confirmQrCodeAuthentication(link: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdSession = exec(TdConfirmQrCodeAuthentication(link, extra))
