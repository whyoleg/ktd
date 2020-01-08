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
 * Returns full information about a basic group by its identifier
 *
 * @basicGroupId - Basic group identifier
 */
suspend fun TelegramClient.getBasicGroupFullInfo(
    basicGroupId: Int = 0
): BasicGroupFullInfo = group(
    GetBasicGroupFullInfo(
        basicGroupId
    )
)

/**
 * Returns full information about a basic group by its identifier
 */
suspend fun TelegramClient.group(
    f: GetBasicGroupFullInfo
): BasicGroupFullInfo = exec(f) as BasicGroupFullInfo
