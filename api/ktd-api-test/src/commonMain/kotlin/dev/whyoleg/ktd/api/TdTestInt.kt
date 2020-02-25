package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A simple object containing a number
 *
 * @property value Number
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testInt")
data class TdTestInt(
    @SerialName("value")
    val value: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
