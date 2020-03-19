package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A simple object containing a vector of objects that hold a number
 *
 * @property value Vector of objects
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testVectorIntObject")
data class TdTestVectorIntObject(
    @SerialName("value")
    val value: List<TdTestInt>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
