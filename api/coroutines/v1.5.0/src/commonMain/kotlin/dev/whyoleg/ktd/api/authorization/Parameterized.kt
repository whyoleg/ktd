@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.authorization

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the current authorization state
 * This is an offline request
 * For informational purposes only
 * Use updateAuthorizationState instead to maintain the current authorization state
 */
suspend fun TelegramClient.getAuthorizationState(): AuthorizationState = authorization(
    GetAuthorizationState()
)
