@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.account

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the period of inactivity after which the account of the current user will automatically be deleted
 */
suspend fun TelegramClient.getAccountTtl(): AccountTtl = account(
    GetAccountTtl()
)

/**
 * Returns the period of inactivity after which the account of the current user will automatically be deleted
 */
suspend fun TelegramClient.account(
    f: GetAccountTtl
): AccountTtl = exec(f) as AccountTtl
