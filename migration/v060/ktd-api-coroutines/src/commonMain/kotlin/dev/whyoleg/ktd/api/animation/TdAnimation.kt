@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.animation

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.animation(f: TdGetSavedAnimations): TdAnimations = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getSavedAnimations()",
            "dev.whyoleg.ktd.api.suspend.getSavedAnimations"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getSavedAnimations(): TdAnimations = exec(TdGetSavedAnimations())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.animation(f: TdAddSavedAnimation): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addSavedAnimation(animation)",
            "dev.whyoleg.ktd.api.suspend.addSavedAnimation"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addSavedAnimation(animation: TdInputFile? = null): TdOk =
        exec(TdAddSavedAnimation(animation))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.animation(f: TdRemoveSavedAnimation): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeSavedAnimation(animation)",
            "dev.whyoleg.ktd.api.suspend.removeSavedAnimation"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeSavedAnimation(animation: TdInputFile? = null): TdOk =
        exec(TdRemoveSavedAnimation(animation))
