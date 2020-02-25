package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Does nothing
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testCallEmpty")
data class TdTestCallEmpty(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdTestCallEmpty {
        return copy(extra = extra.copy(id = id))
    }
}
