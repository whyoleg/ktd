package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a value representing a number of seconds
 *
 * @property seconds Number of seconds
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("seconds")
data class TdSeconds(
    @SerialName("seconds")
    val seconds: Double,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
