@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.supergroup

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns full information about a supergroup or a channel by its identifier, cached for up to 1 minute
 *
 * @supergroupId - Supergroup or channel identifier
 */
suspend fun TelegramClient.getSupergroupFullInfo(
    supergroupId: Int = 0
): SupergroupFullInfo = supergroup(
    GetSupergroupFullInfo(
        supergroupId
    )
)

/**
 * Returns full information about a supergroup or a channel by its identifier, cached for up to 1 minute
 */
suspend fun TelegramClient.supergroup(
    f: GetSupergroupFullInfo
): SupergroupFullInfo = exec(f) as SupergroupFullInfo
