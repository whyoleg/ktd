package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents a secret chat
 *
 * @property id Secret chat identifier
 * @property userId Identifier of the chat partner
 * @property state State of the secret chat
 * @property isOutbound True, if the chat was created by the current user
 *                      Otherwise false
 * @property ttl Current message Time To Live setting (self-destruct timer) for the chat, in seconds
 * @property keyHash Hash of the currently used key for comparison with the hash of the chat partner's key
 *                   This is a string of 36 little-endian bytes, which must be split into groups of 2 bits, each denoting a pixel of one of 4 colors FFFFFF, D5E6F3, 2D5775, and 2F99C9
 *                   The pixels must be used to make a 12x12 square image filled from left to right, top to bottom
 *                   Alternatively, the first 32 bytes of the hash can be converted to the hexadecimal format and printed as 32 2-digit hex numbers
 * @property layer Secret chat layer
 *                 Determines features supported by the other client
 *                 Video notes are supported if the layer >= 66
 *                 Nested text entities and underline and strikethrough entities are supported if the layer >= 101
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("secretChat")
data class TdSecretChat(
    @SerialName("id")
    val id: Int,
    @SerialName("user_id")
    val userId: Int,
    @SerialName("state")
    val state: TdSecretChatState,
    @SerialName("is_outbound")
    val isOutbound: Boolean,
    @SerialName("ttl")
    val ttl: Int,
    @SerialName("key_hash")
    val keyHash: ByteArray,
    @SerialName("layer")
    val layer: Int,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
