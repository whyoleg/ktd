package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns all available Telegram Passport elements
 *
 * @property password Password of the current user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getAllPassportElements")
data class TdGetAllPassportElements(
    @SerialName("password")
    val password: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPassportElements> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetAllPassportElements {
        return copy(extra = extra.copy(id = id))
    }
}
