package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes the photo of a chat
 *
 * @property small A small (160x160) chat photo
 *                 The file can be downloaded only before the photo is changed
 * @property big A big (640x640) chat photo
 *               The file can be downloaded only before the photo is changed
 */
@Serializable
@SerialName("chatPhoto")
data class TdChatPhoto(
    @SerialName("small")
    val small: TdFile,
    @SerialName("big")
    val big: TdFile
) : TdObject
