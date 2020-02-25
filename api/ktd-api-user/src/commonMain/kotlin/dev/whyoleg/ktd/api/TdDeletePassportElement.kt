package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes a Telegram Passport element
 *
 * @property type Element type
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deletePassportElement")
data class TdDeletePassportElement(
    @SerialName("type")
    val type: TdPassportElementType? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeletePassportElement {
        return copy(extra = extra.copy(id = id))
    }
}
