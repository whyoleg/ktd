package dev.whyoleg.ktd

data class TelegramClientConfiguration(val maxEventsCount: Int = 1000, val receiveTimeout: Double = 0.01)