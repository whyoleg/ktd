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
 * Changes the period of inactivity after which the account of the current user will automatically be deleted
 *
 * @ttl - New account TTL
 */
suspend fun TelegramClient.setAccountTtl(
    ttl: AccountTtl? = null
): Ok = account(
    SetAccountTtl(
        ttl
    )
)

/**
 * Changes the period of inactivity after which the account of the current user will automatically be deleted
 */
suspend fun TelegramClient.account(
    f: SetAccountTtl
): Ok = exec(f) as Ok
