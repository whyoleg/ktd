package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the description of an error in a Telegram Passport element
 */
@Serializable
sealed class TdInputPassportElementErrorSource : TdObject
