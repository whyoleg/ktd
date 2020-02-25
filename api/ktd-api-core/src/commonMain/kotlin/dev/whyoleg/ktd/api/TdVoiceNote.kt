package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a voice note
 * The voice note must be encoded with the Opus codec, and stored inside an OGG container
 * Voice notes can have only a single audio channel
 *
 * @property duration Duration of the voice note, in seconds
 *                    As defined by the sender
 * @property waveform A waveform representation of the voice note in 5-bit format
 * @property mimeType MIME type of the file
 *                    As defined by the sender
 * @property voice File containing the voice note
 */
@Serializable
@SerialName("voiceNote")
data class TdVoiceNote(
    @SerialName("duration")
    val duration: Int,
    @SerialName("waveform")
    val waveform: ByteArray,
    @SerialName("mime_type")
    val mimeType: String,
    @SerialName("voice")
    val voice: TdFile
) : TdObject
