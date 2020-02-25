package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the content of a message
 */
@Serializable
sealed class TdMessageContent : TdObject {
    /**
     * A text message
     *
     * @property text Text of the message
     * @property webPage A preview of the web page that's mentioned in the text
     */
    @Serializable
    @SerialName("messageText")
    data class MessageText(
        @SerialName("text")
        val text: TdFormattedText,
        @SerialName("web_page")
        val webPage: TdWebPage?
    ) : TdMessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @property animation The animation description
     * @property caption Animation caption
     * @property isSecret True, if the animation thumbnail must be blurred and the animation must be shown only while tapped
     */
    @Serializable
    @SerialName("messageAnimation")
    data class MessageAnimation(
        @SerialName("animation")
        val animation: TdAnimation,
        @SerialName("caption")
        val caption: TdFormattedText,
        @SerialName("is_secret")
        val isSecret: Boolean
    ) : TdMessageContent()

    /**
     * An audio message
     *
     * @property audio The audio description
     * @property caption Audio caption
     */
    @Serializable
    @SerialName("messageAudio")
    data class MessageAudio(
        @SerialName("audio")
        val audio: TdAudio,
        @SerialName("caption")
        val caption: TdFormattedText
    ) : TdMessageContent()

    /**
     * A document message (general file)
     *
     * @property document The document description
     * @property caption Document caption
     */
    @Serializable
    @SerialName("messageDocument")
    data class MessageDocument(
        @SerialName("document")
        val document: TdDocument,
        @SerialName("caption")
        val caption: TdFormattedText
    ) : TdMessageContent()

    /**
     * A photo message
     *
     * @property photo The photo description
     * @property caption Photo caption
     * @property isSecret True, if the photo must be blurred and must be shown only while tapped
     */
    @Serializable
    @SerialName("messagePhoto")
    data class MessagePhoto(
        @SerialName("photo")
        val photo: TdPhoto,
        @SerialName("caption")
        val caption: TdFormattedText,
        @SerialName("is_secret")
        val isSecret: Boolean
    ) : TdMessageContent()

    /**
     * An expired photo message (self-destructed after TTL has elapsed)
     */
    @Serializable
    @SerialName("messageExpiredPhoto")
    object MessageExpiredPhoto : TdMessageContent()

    /**
     * A sticker message
     *
     * @property sticker The sticker description
     */
    @Serializable
    @SerialName("messageSticker")
    data class MessageSticker(
        @SerialName("sticker")
        val sticker: TdSticker
    ) : TdMessageContent()

    /**
     * A video message
     *
     * @property video The video description
     * @property caption Video caption
     * @property isSecret True, if the video thumbnail must be blurred and the video must be shown only while tapped
     */
    @Serializable
    @SerialName("messageVideo")
    data class MessageVideo(
        @SerialName("video")
        val video: TdVideo,
        @SerialName("caption")
        val caption: TdFormattedText,
        @SerialName("is_secret")
        val isSecret: Boolean
    ) : TdMessageContent()

    /**
     * An expired video message (self-destructed after TTL has elapsed)
     */
    @Serializable
    @SerialName("messageExpiredVideo")
    object MessageExpiredVideo : TdMessageContent()

    /**
     * A video note message
     *
     * @property videoNote The video note description
     * @property isViewed True, if at least one of the recipients has viewed the video note
     * @property isSecret True, if the video note thumbnail must be blurred and the video note must be shown only while tapped
     */
    @Serializable
    @SerialName("messageVideoNote")
    data class MessageVideoNote(
        @SerialName("video_note")
        val videoNote: TdVideoNote,
        @SerialName("is_viewed")
        val isViewed: Boolean,
        @SerialName("is_secret")
        val isSecret: Boolean
    ) : TdMessageContent()

    /**
     * A voice note message
     *
     * @property voiceNote The voice note description
     * @property caption Voice note caption
     * @property isListened True, if at least one of the recipients has listened to the voice note
     */
    @Serializable
    @SerialName("messageVoiceNote")
    data class MessageVoiceNote(
        @SerialName("voice_note")
        val voiceNote: TdVoiceNote,
        @SerialName("caption")
        val caption: TdFormattedText,
        @SerialName("is_listened")
        val isListened: Boolean
    ) : TdMessageContent()

    /**
     * A message with a location
     *
     * @property location The location description
     * @property livePeriod Time relative to the message sent date until which the location can be updated, in seconds
     * @property expiresIn Left time for which the location can be updated, in seconds
     *                     UpdateMessageContent is not sent when this field changes
     */
    @Serializable
    @SerialName("messageLocation")
    data class MessageLocation(
        @SerialName("location")
        val location: TdLocation,
        @SerialName("live_period")
        val livePeriod: Int,
        @SerialName("expires_in")
        val expiresIn: Int
    ) : TdMessageContent()

    /**
     * A message with information about a venue
     *
     * @property venue The venue description
     */
    @Serializable
    @SerialName("messageVenue")
    data class MessageVenue(
        @SerialName("venue")
        val venue: TdVenue
    ) : TdMessageContent()

    /**
     * A message with a user contact
     *
     * @property contact The contact description
     */
    @Serializable
    @SerialName("messageContact")
    data class MessageContact(
        @SerialName("contact")
        val contact: TdContact
    ) : TdMessageContent()

    /**
     * A message with a game
     *
     * @property game The game description
     */
    @Serializable
    @SerialName("messageGame")
    data class MessageGame(
        @SerialName("game")
        val game: TdGame
    ) : TdMessageContent()

    /**
     * A message with a poll
     *
     * @property poll The poll description
     */
    @Serializable
    @SerialName("messagePoll")
    data class MessagePoll(
        @SerialName("poll")
        val poll: TdPoll
    ) : TdMessageContent()

    /**
     * A message with an invoice from a bot
     *
     * @property title Product title
     * @property description Product description
     * @property photo Product photo
     * @property currency Currency for the product price
     * @property totalAmount Product total price in the minimal quantity of the currency
     * @property startParameter Unique invoice bot start_parameter
     *                          To share an invoice use the URL https://t.me/{bot_username}?start={start_parameter}
     * @property isTest True, if the invoice is a test invoice
     * @property needShippingAddress True, if the shipping address should be specified
     * @property receiptMessageId The identifier of the message with the receipt, after the product has been purchased
     */
    @Serializable
    @SerialName("messageInvoice")
    data class MessageInvoice(
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("photo")
        val photo: TdPhoto?,
        @SerialName("currency")
        val currency: String,
        @SerialName("total_amount")
        val totalAmount: Long,
        @SerialName("start_parameter")
        val startParameter: String,
        @SerialName("is_test")
        val isTest: Boolean,
        @SerialName("need_shipping_address")
        val needShippingAddress: Boolean,
        @SerialName("receipt_message_id")
        val receiptMessageId: Long
    ) : TdMessageContent()

    /**
     * A message with information about an ended call
     *
     * @property discardReason Reason why the call was discarded
     * @property duration Call duration, in seconds
     */
    @Serializable
    @SerialName("messageCall")
    data class MessageCall(
        @SerialName("discard_reason")
        val discardReason: TdCallDiscardReason,
        @SerialName("duration")
        val duration: Int
    ) : TdMessageContent()

    /**
     * A newly created basic group
     *
     * @property title Title of the basic group
     * @property memberUserIds User identifiers of members in the basic group
     */
    @Serializable
    @SerialName("messageBasicGroupChatCreate")
    data class MessageBasicGroupChatCreate(
        @SerialName("title")
        val title: String,
        @SerialName("member_user_ids")
        val memberUserIds: IntArray
    ) : TdMessageContent()

    /**
     * A newly created supergroup or channel
     *
     * @property title Title of the supergroup or channel
     */
    @Serializable
    @SerialName("messageSupergroupChatCreate")
    data class MessageSupergroupChatCreate(
        @SerialName("title")
        val title: String
    ) : TdMessageContent()

    /**
     * An updated chat title
     *
     * @property title New chat title
     */
    @Serializable
    @SerialName("messageChatChangeTitle")
    data class MessageChatChangeTitle(
        @SerialName("title")
        val title: String
    ) : TdMessageContent()

    /**
     * An updated chat photo
     *
     * @property photo New chat photo
     */
    @Serializable
    @SerialName("messageChatChangePhoto")
    data class MessageChatChangePhoto(
        @SerialName("photo")
        val photo: TdPhoto
    ) : TdMessageContent()

    /**
     * A deleted chat photo
     */
    @Serializable
    @SerialName("messageChatDeletePhoto")
    object MessageChatDeletePhoto : TdMessageContent()

    /**
     * New chat members were added
     *
     * @property memberUserIds User identifiers of the new members
     */
    @Serializable
    @SerialName("messageChatAddMembers")
    data class MessageChatAddMembers(
        @SerialName("member_user_ids")
        val memberUserIds: IntArray
    ) : TdMessageContent()

    /**
     * A new member joined the chat by invite link
     */
    @Serializable
    @SerialName("messageChatJoinByLink")
    object MessageChatJoinByLink : TdMessageContent()

    /**
     * A chat member was deleted
     *
     * @property userId User identifier of the deleted chat member
     */
    @Serializable
    @SerialName("messageChatDeleteMember")
    data class MessageChatDeleteMember(
        @SerialName("user_id")
        val userId: Int
    ) : TdMessageContent()

    /**
     * A basic group was upgraded to a supergroup and was deactivated as the result
     *
     * @property supergroupId Identifier of the supergroup to which the basic group was upgraded
     */
    @Serializable
    @SerialName("messageChatUpgradeTo")
    data class MessageChatUpgradeTo(
        @SerialName("supergroup_id")
        val supergroupId: Int
    ) : TdMessageContent()

    /**
     * A supergroup has been created from a basic group
     *
     * @property title Title of the newly created supergroup
     * @property basicGroupId The identifier of the original basic group
     */
    @Serializable
    @SerialName("messageChatUpgradeFrom")
    data class MessageChatUpgradeFrom(
        @SerialName("title")
        val title: String,
        @SerialName("basic_group_id")
        val basicGroupId: Int
    ) : TdMessageContent()

    /**
     * A message has been pinned
     *
     * @property messageId Identifier of the pinned message, can be an identifier of a deleted message or 0
     */
    @Serializable
    @SerialName("messagePinMessage")
    data class MessagePinMessage(
        @SerialName("message_id")
        val messageId: Long
    ) : TdMessageContent()

    /**
     * A screenshot of a message in the chat has been taken
     */
    @Serializable
    @SerialName("messageScreenshotTaken")
    object MessageScreenshotTaken : TdMessageContent()

    /**
     * The TTL (Time To Live) setting messages in a secret chat has been changed
     *
     * @property ttl New TTL
     */
    @Serializable
    @SerialName("messageChatSetTtl")
    data class MessageChatSetTtl(
        @SerialName("ttl")
        val ttl: Int
    ) : TdMessageContent()

    /**
     * A non-standard action has happened in the chat
     *
     * @property text Message text to be shown in the chat
     */
    @Serializable
    @SerialName("messageCustomServiceAction")
    data class MessageCustomServiceAction(
        @SerialName("text")
        val text: String
    ) : TdMessageContent()

    /**
     * A new high score was achieved in a game
     *
     * @property gameMessageId Identifier of the message with the game, can be an identifier of a deleted message
     * @property gameId Identifier of the game
     *                  May be different from the games presented in the message with the game
     * @property score New score
     */
    @Serializable
    @SerialName("messageGameScore")
    data class MessageGameScore(
        @SerialName("game_message_id")
        val gameMessageId: Long,
        @SerialName("game_id")
        val gameId: Long,
        @SerialName("score")
        val score: Int
    ) : TdMessageContent()

    /**
     * A payment has been completed
     *
     * @property invoiceMessageId Identifier of the message with the corresponding invoice
     *                            Can be an identifier of a deleted message
     * @property currency Currency for the price of the product
     * @property totalAmount Total price for the product, in the minimal quantity of the currency
     */
    @Serializable
    @SerialName("messagePaymentSuccessful")
    data class MessagePaymentSuccessful(
        @SerialName("invoice_message_id")
        val invoiceMessageId: Long,
        @SerialName("currency")
        val currency: String,
        @SerialName("total_amount")
        val totalAmount: Long
    ) : TdMessageContent()

    /**
     * A contact has registered with Telegram
     */
    @Serializable
    @SerialName("messageContactRegistered")
    object MessageContactRegistered : TdMessageContent()

    /**
     * The current user has connected a website by logging in using Telegram Login Widget on it
     *
     * @property domainName Domain name of the connected website
     */
    @Serializable
    @SerialName("messageWebsiteConnected")
    data class MessageWebsiteConnected(
        @SerialName("domain_name")
        val domainName: String
    ) : TdMessageContent()

    /**
     * Telegram Passport data has been sent
     *
     * @property types List of Telegram Passport element types sent
     */
    @Serializable
    @SerialName("messagePassportDataSent")
    data class MessagePassportDataSent(
        @SerialName("types")
        val types: List<TdPassportElementType>
    ) : TdMessageContent()

    /**
     * Message content that is not supported by the client
     */
    @Serializable
    @SerialName("messageUnsupported")
    object MessageUnsupported : TdMessageContent()
}
