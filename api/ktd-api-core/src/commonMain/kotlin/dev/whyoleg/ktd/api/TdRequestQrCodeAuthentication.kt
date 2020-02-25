package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Requests QR code authentication by scanning a QR code on another logged in device
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 *
 * @property otherUserIds List of user identifiers of other users currently using the client
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("requestQrCodeAuthentication")
data class TdRequestQrCodeAuthentication(
    @SerialName("other_user_ids")
    val otherUserIds: IntArray = intArrayOf(),
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRequestQrCodeAuthentication {
        return copy(extra = extra.copy(id = id))
    }
}
