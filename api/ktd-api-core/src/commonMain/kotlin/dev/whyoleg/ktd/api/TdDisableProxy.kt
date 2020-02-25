package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Disables the currently enabled proxy
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("disableProxy")
data class TdDisableProxy(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDisableProxy {
        return copy(extra = extra.copy(id = id))
    }
}
