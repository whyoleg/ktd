package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A simple object containing a vector of numbers
 *
 * @property value Vector of numbers
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testVectorInt")
data class TdTestVectorInt(
    @SerialName("value")
    val value: IntArray,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
