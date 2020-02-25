package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a part of a file
 *
 * @property data File bytes
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("filePart")
data class TdFilePart(
    @SerialName("data")
    val data: ByteArray,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
