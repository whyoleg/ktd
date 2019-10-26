@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.profile

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Uploads a new profile photo for the current user
 * If something changes, updateUser will be sent
 */
suspend fun TelegramClient.profile(
    f: SetProfilePhoto
): Ok = execRaw(f) as Ok

/**
 * Deletes a profile photo
 * If something changes, updateUser will be sent
 */
suspend fun TelegramClient.profile(
    f: DeleteProfilePhoto
): Ok = execRaw(f) as Ok
