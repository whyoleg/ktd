package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Confirms QR code authentication on another device
 * Returns created session on success
 *
 * @property link A link from a QR code
 *                The link must be scanned by the in-app camera
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("confirmQrCodeAuthentication")
data class TdConfirmQrCodeAuthentication(
    @SerialName("link")
    val link: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdSession> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdConfirmQrCodeAuthentication {
        return copy(extra = extra.copy(id = id))
    }
}
