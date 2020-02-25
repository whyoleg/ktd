package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns a public HTTPS link to a message
 * Available only for messages in supergroups and channels with a username
 *
 * @property chatId Identifier of the chat to which the message belongs
 * @property messageId Identifier of the message
 * @property forAlbum Pass true if a link for a whole media album should be returned
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPublicMessageLink")
data class TdGetPublicMessageLink(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("message_id")
    val messageId: Long = 0L,
    @SerialName("for_album")
    val forAlbum: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPublicMessageLink> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPublicMessageLink {
        return copy(extra = extra.copy(id = id))
    }
}
