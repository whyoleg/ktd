@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all user contacts
 */
suspend fun TelegramClient.getContacts(): Users = user(
    GetContacts()
)

/**
 * Returns all user contacts
 */
suspend fun TelegramClient.user(
    f: GetContacts
): Users = exec(f) as Users
