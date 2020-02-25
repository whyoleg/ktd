package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a TDLib internal log verbosity level
 *
 * @property verbosityLevel Log verbosity level
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("logVerbosityLevel")
data class TdLogVerbosityLevel(
    @SerialName("verbosity_level")
    val verbosityLevel: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
