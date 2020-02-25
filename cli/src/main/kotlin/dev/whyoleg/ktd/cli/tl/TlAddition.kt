package dev.whyoleg.ktd.cli.tl

import dev.whyoleg.ktd.cli.tl.TlAddition.*

sealed class TlAddition {
    interface WithMessage {
        val message: String?
    }

    data class Nullable(override val message: String? = null) : TlAddition(), WithMessage {
        override fun toString(): String = "Nullable" + (message?.let { " - $it" } ?: "")
    }

    object BotsOnly : TlAddition() {
        override fun toString(): String = "BotsOnly"
    }

    object TestOnly : TlAddition() {
        override fun toString(): String = "TestOnly"
    }

    data class Documentation(override val message: String) : TlAddition(), WithMessage {
        override fun toString(): String = "Documentation - ${message.capitalize()}"
    }

    data class SizeRequired(val min: Int, val max: Int) : TlAddition() {
        override fun toString(): String = "SizeRequired - must be in range [$min, $max]"
    }

    data class StartWithRequired(val list: List<String>) : TlAddition() {
        override fun toString(): String = "StartWithRequired - should begin with one of $list"
    }

    object NonEmpty : TlAddition() {
        override fun toString(): String = "NonEmpty - must be non-empty"
    }

    object Sync : TlAddition() {
        override fun toString(): String = "Sync - can be called synchronously"
    }

}

@Suppress("FunctionName")
fun TlAddition(addition: String): TlAddition = when (addition.toLowerCase()) {
    "can be called synchronously"                 -> Sync
    "must be non-empty"                           -> NonEmpty
    "may be null",
    "optional",
    "may be empty"                                -> Nullable()
    "may be empty to de-register a device",
    "may be empty if not applicable",
    "pass null to stop sharing the live location" ->
        Nullable(addition)
    "for testing only"                            -> TestOnly
    "for bots only",
    "can be used only by bots and only in private chats",
    "only available to bots",
    "to log in as a bot"                          -> BotsOnly
    """should begin with "https://t.me/joinchat/", "https://telegram.me/joinchat/", or "https://telegram.dog/joinchat/"""" ->
        StartWithRequired(listOf("https://t.me/joinchat/", "https://telegram.me/joinchat/", "https://telegram.dog/joinchat/"))
    "up to 100"                                                                                                            ->
        SizeRequired(0, 100)
    "use 65"                                                                                                               ->
        SizeRequired(65, 65)
    "must be non-negative"                                                                                                 ->
        SizeRequired(0, Int.MAX_VALUE)
    else                                          -> {
        val splitted = addition.substringBefore(" ").split("-").mapNotNull(String::toIntOrNull)
        if (splitted.size > 1) {
            val (min, max) = splitted
            SizeRequired(min, max)
        } else {
            Documentation(addition)
        }
    }
}
