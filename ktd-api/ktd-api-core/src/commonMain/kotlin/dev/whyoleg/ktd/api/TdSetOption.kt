package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets the value of an option
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Only writable options can be set
 * Can be called before authorization
 *
 * @property name The name of the option
 * @property value The new value of the option
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setOption")
data class TdSetOption(
    @SerialName("name")
    val name: String? = null,
    @SerialName("value")
    val value: TdOptionValue? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetOption {
        return copy(extra = extra.copy(id = id))
    }
}
