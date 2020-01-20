@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Clears draft messages in all chats
 *
 * @excludeSecretChats - If true, local draft messages in secret chats will not be cleared
 */
suspend fun TelegramClient.clearAllDraftMessages(
    excludeSecretChats: Boolean = false
): Ok = message(
    ClearAllDraftMessages(
        excludeSecretChats
    )
)

/**
 * Clears draft messages in all chats
 */
suspend fun TelegramClient.message(
    f: ClearAllDraftMessages
): Ok = exec(f) as Ok
