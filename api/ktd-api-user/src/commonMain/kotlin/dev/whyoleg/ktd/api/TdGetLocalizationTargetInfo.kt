package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about the current localization target
 * This is an offline request if only_local is true
 * Can be called before authorization
 *
 * @property onlyLocal If true, returns only locally available information without sending network requests
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLocalizationTargetInfo")
data class TdGetLocalizationTargetInfo(
    @SerialName("only_local")
    val onlyLocal: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdLocalizationTargetInfo> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLocalizationTargetInfo {
        return copy(extra = extra.copy(id = id))
    }
}
