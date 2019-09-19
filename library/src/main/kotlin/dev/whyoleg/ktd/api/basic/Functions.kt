@file:Suppress("unused")

package dev.whyoleg.ktd.api.basic

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a basic group by its identifier. This is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.basic(
    f: GetBasicGroup
): BasicGroup = execRaw(f) as BasicGroup

/**
 * Returns full information about a basic group by its identifier
 */
suspend fun TelegramClient.basic(
    f: GetBasicGroupFullInfo
): BasicGroupFullInfo = execRaw(f) as BasicGroupFullInfo
