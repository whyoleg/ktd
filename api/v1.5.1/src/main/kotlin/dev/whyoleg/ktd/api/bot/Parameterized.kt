@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.bot

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Informs the server about the number of pending bot updates if they haven't been processed for a long time
 *
 * @pendingUpdateCount - The number of pending updates
 * @errorMessage - The last error message
 */
@BotsOnly
suspend fun TelegramClient.setBotUpdatesStatus(
    pendingUpdateCount: Int = 0,
    errorMessage: String
): Ok = bot(
    SetBotUpdatesStatus(
        pendingUpdateCount,
        errorMessage
    )
)
