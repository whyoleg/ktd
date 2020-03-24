package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Finishes the file generation
 *
 * @property generationId The identifier of the generation process
 * @property error If set, means that file generation has failed and should be terminated
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("finishFileGeneration")
data class TdFinishFileGeneration(
    @SerialName("generation_id")
    val generationId: Long = 0L,
    @SerialName("error")
    val error: TdError? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdFinishFileGeneration {
        return copy(extra = extra.copy(id = id))
    }
}
