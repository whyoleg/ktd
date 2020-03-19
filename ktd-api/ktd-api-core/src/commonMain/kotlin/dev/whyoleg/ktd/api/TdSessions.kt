package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a list of sessions
 *
 * @property sessions List of sessions
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sessions")
data class TdSessions(
    @SerialName("sessions")
    val sessions: List<TdSession>,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
