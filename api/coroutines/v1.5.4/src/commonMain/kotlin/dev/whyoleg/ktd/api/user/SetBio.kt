@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the bio of the current user
 *
 * @bio - The new value of the user bio
 */
suspend fun TelegramClient.setBio(
    bio: String? = null
): Ok = user(
    SetBio(
        bio
    )
)

/**
 * Changes the bio of the current user
 */
suspend fun TelegramClient.user(
    f: SetBio
): Ok = exec(f) as Ok
