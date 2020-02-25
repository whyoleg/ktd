package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the value of an option by its name
 * (Check the list of available options on https://core.telegram.org/tdlib/options.) Can be called before authorization
 *
 * @property name The name of the option
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getOption")
data class TdGetOption(
    @SerialName("name")
    val name: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOptionValue> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetOption {
        return copy(extra = extra.copy(id = id))
    }
}
