@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.can

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Checks whether the current session can be used to transfer a chat ownership to another user
 */
suspend fun TelegramClient.canTransferOwnership(): CanTransferOwnershipResult = can(
    CanTransferOwnership()
)

/**
 * Checks whether the current session can be used to transfer a chat ownership to another user
 */
suspend fun TelegramClient.can(
    f: CanTransferOwnership
): CanTransferOwnershipResult = exec(f) as CanTransferOwnershipResult
