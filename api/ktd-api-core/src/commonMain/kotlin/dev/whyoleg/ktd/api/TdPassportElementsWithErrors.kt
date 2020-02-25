package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a Telegram Passport elements and corresponding errors
 *
 * @property elements Telegram Passport elements
 * @property errors Errors in the elements that are already available
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("passportElementsWithErrors")
data class TdPassportElementsWithErrors(
    @SerialName("elements")
    val elements: List<TdPassportElement>,
    @SerialName("errors")
    val errors: List<TdPassportElementError>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
