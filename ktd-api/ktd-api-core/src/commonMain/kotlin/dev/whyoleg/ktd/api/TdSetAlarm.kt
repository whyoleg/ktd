package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Succeeds after a specified amount of time has passed
 * Can be called before authorization
 * Can be called before initialization
 *
 * @property seconds Number of seconds before the function returns
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setAlarm")
data class TdSetAlarm(
    @SerialName("seconds")
    val seconds: Double = 0.0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetAlarm {
        return copy(extra = extra.copy(id = id))
    }
}
