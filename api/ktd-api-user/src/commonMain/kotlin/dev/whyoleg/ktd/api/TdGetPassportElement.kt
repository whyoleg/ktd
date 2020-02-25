package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns one of the available Telegram Passport elements
 *
 * @property type Telegram Passport element type
 * @property password Password of the current user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPassportElement")
data class TdGetPassportElement(
    @SerialName("type")
    val type: TdPassportElementType? = null,
    @SerialName("password")
    val password: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPassportElement> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPassportElement {
        return copy(extra = extra.copy(id = id))
    }
}
