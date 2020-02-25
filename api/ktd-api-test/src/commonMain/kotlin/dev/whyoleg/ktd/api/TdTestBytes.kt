package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A simple object containing a sequence of bytes
 *
 * @property value Bytes
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("testBytes")
data class TdTestBytes(
    @SerialName("value")
    val value: ByteArray,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
