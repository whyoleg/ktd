package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a file
 *
 * @property id Unique file identifier
 * @property size File size
 *                0 if unknown
 * @property expectedSize Expected file size in case the exact file size is unknown, but an approximate size is known
 *                        Can be used to show download/upload progress
 * @property local Information about the local copy of the file
 * @property remote Information about the remote copy of the file
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("file")
data class TdFile(
    @SerialName("id")
    val id: Int,
    @SerialName("size")
    val size: Int,
    @SerialName("expected_size")
    val expectedSize: Int,
    @SerialName("local")
    val local: TdLocalFile,
    @SerialName("remote")
    val remote: TdRemoteFile,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
