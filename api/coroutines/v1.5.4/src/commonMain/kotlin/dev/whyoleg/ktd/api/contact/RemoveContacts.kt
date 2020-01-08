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
 * Removes users from the contact list
 *
 * @userIds - Identifiers of users to be deleted
 */
suspend fun TelegramClient.removeContacts(
    userIds: IntArray = intArrayOf()
): Ok = contact(
    RemoveContacts(
        userIds
    )
)

/**
 * Removes users from the contact list
 */
suspend fun TelegramClient.contact(
    f: RemoveContacts
): Ok = exec(f) as Ok
