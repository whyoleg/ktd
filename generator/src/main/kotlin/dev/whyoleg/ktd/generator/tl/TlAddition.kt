package dev.whyoleg.ktd.generator.tl

import dev.whyoleg.ktd.generator.tl.TlAddition.*

sealed class TlAddition {
    interface WithMessage {
        val message: String?
    }

    interface Annotation {
        val annotation: String
    }

    data class Nullable(override val message: String? = null) : TlAddition(), WithMessage

    object BotsOnly : TlAddition(), Annotation {
        override val annotation: String = "BotsOnly"
    }

    object TestingOnly : TlAddition(), Annotation {
        override val annotation: String = "TestingOnly"
    }

    data class Other(override val message: String? = null) : TlAddition(), WithMessage
    data class SizeRequired(val min: Int, val max: Int) : TlAddition()
    data class StartWithRequired(val list: List<String>) : TlAddition()

    object NonEmpty : TlAddition()

    object Sync : TlAddition()

    companion object {
        fun annotations() = listOf<Annotation>(BotsOnly, TestingOnly)
    }
}

@Suppress("FunctionName")
fun TlAddition(addition: String): TlAddition = when (addition.toLowerCase()) {
    "must be non-empty"                                                                                                    -> NonEmpty
    "may be null",
    "optional",
    "may be empty"                                                                                                         -> Nullable()
    "may be empty to de-register a device",
    "may be empty if not applicable",
    "pass null to stop sharing the live location"                                                                          ->
        Nullable(addition)
    "for testing only"                                                                                                     -> TestingOnly
    "for bots only",
    "can be used only by bots and only in private chats",
    "only available to bots",
    "to log in as a bot"                                                                                                   -> BotsOnly
    """should begin with "https://t.me/joinchat/", "https://telegram.me/joinchat/", or "https://telegram.dog/joinchat/"""" ->
        StartWithRequired(listOf("https://t.me/joinchat/", "https://telegram.me/joinchat/", "https://telegram.dog/joinchat/"))
    "up to 100"                                                                                                            ->
        SizeRequired(0, 100)
    "use 65"                                                                                                               ->
        SizeRequired(65, 65)
    "must be non-negative"                                                                                                 ->
        SizeRequired(0, Int.MAX_VALUE)
    else                                                                                                                   -> {
        val splitted = addition.substringBefore(spaceToken).split(dashToken).mapNotNull(String::toIntOrNull)
        if (splitted.size > 1) {
            val (min, max) = splitted
            SizeRequired(min, max)
        } else {
            Other(addition)
        }
    }
}
