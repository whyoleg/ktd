@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.profile

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.profile(f: TdSetProfilePhoto): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setProfilePhoto(photo)",
            "dev.whyoleg.ktd.api.suspend.setProfilePhoto"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setProfilePhoto(photo: TdInputFile? = null): TdOk =
        exec(TdSetProfilePhoto(photo))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.profile(f: TdDeleteProfilePhoto): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteProfilePhoto(profilePhotoId)",
            "dev.whyoleg.ktd.api.suspend.deleteProfilePhoto"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteProfilePhoto(profilePhotoId: Long = 0L): TdOk =
        exec(TdDeleteProfilePhoto(profilePhotoId))
