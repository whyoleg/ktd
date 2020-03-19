package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * New terms of service must be accepted by the user
 * If the terms of service are declined, then the deleteAccount method should be called with the reason "Decline ToS update"
 *
 * @property termsOfServiceId Identifier of the terms of service
 * @property termsOfService The new terms of service
 */
@Serializable
@SerialName("updateTermsOfService")
data class TdUpdateTermsOfService(
    @SerialName("terms_of_service_id")
    val termsOfServiceId: String,
    @SerialName("terms_of_service")
    val termsOfService: TdTermsOfService
) : TdUpdate
