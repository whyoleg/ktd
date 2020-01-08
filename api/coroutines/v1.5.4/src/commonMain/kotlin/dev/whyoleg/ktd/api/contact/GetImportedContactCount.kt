@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.contact

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the total number of imported contacts
 */
suspend fun TelegramClient.getImportedContactCount(): Count = contact(
    GetImportedContactCount()
)

/**
 * Returns the total number of imported contacts
 */
suspend fun TelegramClient.contact(
    f: GetImportedContactCount
): Count = exec(f) as Count
