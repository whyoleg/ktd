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
 */
@BotsOnly
suspend fun TelegramClient.bot(
    f: SetBotUpdatesStatus
): Ok = execRaw(f) as Ok
