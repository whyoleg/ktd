package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a counter
 *
 * @property count Count
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("count")
data class TdCount(
    @SerialName("count")
    val count: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
