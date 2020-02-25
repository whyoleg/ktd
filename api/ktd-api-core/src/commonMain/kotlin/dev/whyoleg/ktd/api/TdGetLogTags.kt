package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns list of available TDLib internal log tags, for example, ["actor", "binlog", "connections", "notifications", "proxy"]
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLogTags")
data class TdGetLogTags(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdLogTags> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLogTags {
        return copy(extra = extra.copy(id = id))
    }
}
