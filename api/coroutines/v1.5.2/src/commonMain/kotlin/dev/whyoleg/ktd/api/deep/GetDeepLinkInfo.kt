@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.deep

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a tg:// deep link
 * Use "tg://need_update_for_some_feature" or "tg:some_unsupported_feature" for testing
 * Returns a 404 error for unknown links
 * Can be called before authorization
 *
 * @link - The link
 */
suspend fun TelegramClient.getDeepLinkInfo(
    link: String? = null
): DeepLinkInfo = deep(
    GetDeepLinkInfo(
        link
    )
)

/**
 * Returns information about a tg:// deep link
 * Use "tg://need_update_for_some_feature" or "tg:some_unsupported_feature" for testing
 * Returns a 404 error for unknown links
 * Can be called before authorization
 */
suspend fun TelegramClient.deep(
    f: GetDeepLinkInfo
): DeepLinkInfo = exec(f) as DeepLinkInfo
