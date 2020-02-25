package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Accepts Telegram terms of services
 *
 * @property termsOfServiceId Terms of service identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("acceptTermsOfService")
data class TdAcceptTermsOfService(
    @SerialName("terms_of_service_id")
    val termsOfServiceId: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAcceptTermsOfService {
        return copy(extra = extra.copy(id = id))
    }
}
