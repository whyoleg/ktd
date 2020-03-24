package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a list of proxy servers
 *
 * @property proxies List of proxy servers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("proxies")
data class TdProxies(
    @SerialName("proxies")
    val proxies: List<TdProxy>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
