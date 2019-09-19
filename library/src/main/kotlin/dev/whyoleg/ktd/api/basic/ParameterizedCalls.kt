@file:Suppress("unused")

package dev.whyoleg.ktd.api.basic

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a basic group by its identifier. This is an offline request if the current user is not a bot
 *
 * @basicGroupId - Basic group identifier
 */
suspend fun TelegramClient.getBasicGroup(
    basicGroupId: Int
): BasicGroup = basic(
    GetBasicGroup(
        basicGroupId
    )
)

/**
 * Returns full information about a basic group by its identifier
 *
 * @basicGroupId - Basic group identifier
 */
suspend fun TelegramClient.getBasicGroupFullInfo(
    basicGroupId: Int
): BasicGroupFullInfo = basic(
    GetBasicGroupFullInfo(
        basicGroupId
    )
)
