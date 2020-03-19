package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains information about a link to a message in a chat
 *
 * @property isPublic True, if the link is a public link for a message in a chat
 * @property chatId If found, identifier of the chat to which the message belongs, 0 otherwise
 * @property message If found, the linked message
 * @property forAlbum True, if the whole media album to which the message belongs is linked
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("messageLinkInfo")
data class TdMessageLinkInfo(
    @SerialName("is_public")
    val isPublic: Boolean,
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("message")
    val message: TdMessage?,
    @SerialName("for_album")
    val forAlbum: Boolean,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
