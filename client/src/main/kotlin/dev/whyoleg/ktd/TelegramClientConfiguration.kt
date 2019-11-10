package dev.whyoleg.ktd

import kotlin.time.*

data class TelegramClientConfiguration(val maxEventsCount: Int = 1000, val receiveTimeout: Duration = 1.seconds)
