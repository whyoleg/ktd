package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a simple network request to the Telegram servers
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testNetwork")
data class TdTestNetwork(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestNetwork {
        return copy(extra = extra.copy(id = id))
    }
}
