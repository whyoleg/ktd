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
 * Clears all imported contacts, contact list remains unchanged
 */
suspend fun TelegramClient.clearImportedContacts(): Ok = contact(
    ClearImportedContacts()
)

/**
 * Clears all imported contacts, contact list remains unchanged
 */
suspend fun TelegramClient.contact(
    f: ClearImportedContacts
): Ok = exec(f) as Ok
