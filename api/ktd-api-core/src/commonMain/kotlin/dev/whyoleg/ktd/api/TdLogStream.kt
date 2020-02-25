package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a stream to which TDLib internal log is written
 */
@Serializable
sealed class TdLogStream : TdResponse {
    /**
     * The log is written to stderr or an OS specific log
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logStreamDefault")
    data class Default(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdLogStream()

    /**
     * The log is written to a file
     *
     * @property path Path to the file to where the internal TDLib log will be written
     * @property maxFileSize The maximum size of the file to where the internal TDLib log is written before the file will be auto-rotated
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logStreamFile")
    data class File(
        @SerialName("path")
        val path: String,
        @SerialName("max_file_size")
        val maxFileSize: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdLogStream()

    /**
     * The log is written nowhere
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logStreamEmpty")
    data class Empty(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : TdLogStream()
}
