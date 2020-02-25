package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes actions which should be possible to do through a chat action bar
 */
@Serializable
sealed class TdChatActionBar : TdObject {
    /**
     * The chat can be reported as spam using the method reportChat with the reason chatReportReasonSpam
     */
    @Serializable
    @SerialName("chatActionBarReportSpam")
    object ReportSpam : TdChatActionBar()

    /**
     * The chat is a location-based supergroup, which can be reported as having unrelated location using the method reportChat with the reason chatReportReasonUnrelatedLocation
     */
    @Serializable
    @SerialName("chatActionBarReportUnrelatedLocation")
    object ReportUnrelatedLocation : TdChatActionBar()

    /**
     * The chat is a private or secret chat, which can be reported using the method reportChat, or the other user can be added to the contact list using the method addContact, or the other user can be blocked using the method blockUser
     */
    @Serializable
    @SerialName("chatActionBarReportAddBlock")
    object ReportAddBlock : TdChatActionBar()

    /**
     * The chat is a private or secret chat and the other user can be added to the contact list using the method addContact
     */
    @Serializable
    @SerialName("chatActionBarAddContact")
    object AddContact : TdChatActionBar()

    /**
     * The chat is a private or secret chat with a mutual contact and the user's phone number can be shared with the other user using the method sharePhoneNumber
     */
    @Serializable
    @SerialName("chatActionBarSharePhoneNumber")
    object SharePhoneNumber : TdChatActionBar()
}
