package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about saved Telegram Passport elements
 *
 * @property elements Telegram Passport elements
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("passportElements")
data class TdPassportElements(
    @SerialName("elements")
    val elements: List<TdPassportElement>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
