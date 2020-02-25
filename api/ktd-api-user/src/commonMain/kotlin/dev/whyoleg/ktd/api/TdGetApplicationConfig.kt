package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns application config, provided by the server
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getApplicationConfig")
data class TdGetApplicationConfig(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdJsonValue> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetApplicationConfig {
        return copy(extra = extra.copy(id = id))
    }
}
