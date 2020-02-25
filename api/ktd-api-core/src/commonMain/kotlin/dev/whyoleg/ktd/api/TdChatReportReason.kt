package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the reason why a chat is reported
 */
@Serializable
sealed class TdChatReportReason : TdObject {
    /**
     * The chat contains spam messages
     */
    @Serializable
    @SerialName("chatReportReasonSpam")
    object Spam : TdChatReportReason()

    /**
     * The chat promotes violence
     */
    @Serializable
    @SerialName("chatReportReasonViolence")
    object Violence : TdChatReportReason()

    /**
     * The chat contains pornographic messages
     */
    @Serializable
    @SerialName("chatReportReasonPornography")
    object Pornography : TdChatReportReason()

    /**
     * The chat has child abuse related content
     */
    @Serializable
    @SerialName("chatReportReasonChildAbuse")
    object ChildAbuse : TdChatReportReason()

    /**
     * The chat contains copyrighted content
     */
    @Serializable
    @SerialName("chatReportReasonCopyright")
    object Copyright : TdChatReportReason()

    /**
     * The location-based chat is unrelated to its stated location
     */
    @Serializable
    @SerialName("chatReportReasonUnrelatedLocation")
    object UnrelatedLocation : TdChatReportReason()

    /**
     * A custom reason provided by the user
     *
     * @property text Report text
     */
    @Serializable
    @SerialName("chatReportReasonCustom")
    data class Custom(
        @SerialName("text")
        val text: String
    ) : TdChatReportReason()
}
