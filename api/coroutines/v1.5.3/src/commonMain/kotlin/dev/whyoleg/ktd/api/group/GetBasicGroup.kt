@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.group

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a basic group by its identifier
 * This is an offline request if the current user is not a bot
 *
 * @basicGroupId - Basic group identifier
 */
suspend fun TelegramClient.getBasicGroup(
    basicGroupId: Int = 0
): BasicGroup = group(
    GetBasicGroup(
        basicGroupId
    )
)

/**
 * Returns information about a basic group by its identifier
 * This is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.group(
    f: GetBasicGroup
): BasicGroup = exec(f) as BasicGroup
