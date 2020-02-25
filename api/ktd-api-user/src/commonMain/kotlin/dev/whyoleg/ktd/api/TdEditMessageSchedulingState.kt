package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Edits the time when a scheduled message will be sent
 * Scheduling state of all messages in the same album or forwarded together with the message will be also changed
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property schedulingState The new message scheduling state
 *                           Pass null to send the message immediately
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("editMessageSchedulingState")
data class TdEditMessageSchedulingState(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("scheduling_state")
    val schedulingState: TdMessageSchedulingState? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdEditMessageSchedulingState {
        return copy(extra = extra.copy(id = id))
    }
}
