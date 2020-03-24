package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets the parameters for TDLib initialization
 * Works only when the current authorization state is authorizationStateWaitTdlibParameters
 *
 * @property parameters Parameters
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setTdlibParameters")
data class TdSetTdlibParameters(
    @SerialName("parameters")
    val parameters: TdTdlibParameters? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetTdlibParameters {
        return copy(extra = extra.copy(id = id))
    }
}
