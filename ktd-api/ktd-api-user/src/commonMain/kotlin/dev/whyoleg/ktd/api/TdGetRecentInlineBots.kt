package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns up to 20 recently used inline bots in the order of their last usage
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getRecentInlineBots")
data class TdGetRecentInlineBots(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUsers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetRecentInlineBots {
        return copy(extra = extra.copy(id = id))
    }
}
