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
 * Changes the username of a supergroup or channel, requires owner privileges in the supergroup or channel
 *
 * @supergroupId - Identifier of the supergroup or channel
 * @username - New value of the username
 *             Use an empty string to remove the username
 */
suspend fun TelegramClient.setSupergroupUsername(
    supergroupId: Int = 0,
    username: String? = null
): Ok = supergroup(
    SetSupergroupUsername(
        supergroupId,
        username
    )
)

/**
 * Changes the username of a supergroup or channel, requires owner privileges in the supergroup or channel
 */
suspend fun TelegramClient.supergroup(
    f: SetSupergroupUsername
): Ok = exec(f) as Ok
