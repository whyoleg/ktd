package dev.whyoleg.ktd

data class TelegramException(val code: Int, override val message: String) : RuntimeException(message)