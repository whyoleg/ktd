package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains a public HTTPS link to a message in a supergroup or channel with a username
 *
 * @property link Message link
 * @property html HTML-code for embedding the message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("publicMessageLink")
data class TdPublicMessageLink(
    @SerialName("link")
    val link: String,
    @SerialName("html")
    val html: String,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
