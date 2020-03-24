package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Informs TDLib on a file generation progress
 *
 * @property generationId The identifier of the generation process
 * @property expectedSize Expected size of the generated file, in bytes
 *                        0 if unknown
 * @property localPrefixSize The number of bytes already generated
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setFileGenerationProgress")
data class TdSetFileGenerationProgress(
    @SerialName("generation_id")
    val generationId: Long = 0L,
    @SerialName("expected_size")
    val expectedSize: Int = 0,
    @SerialName("local_prefix_size")
    val localPrefixSize: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetFileGenerationProgress {
        return copy(extra = extra.copy(id = id))
    }
}
