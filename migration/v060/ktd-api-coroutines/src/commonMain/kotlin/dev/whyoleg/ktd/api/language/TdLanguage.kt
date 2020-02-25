@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.language

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.language(f: TdGetLanguagePackString): TdLanguagePackStringValue = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("getLanguagePackString(languagePackDatabasePath, localizationTarget, languagePackId, key)",
            "dev.whyoleg.ktd.api.suspend.getLanguagePackString"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLanguagePackString(
    languagePackDatabasePath: String? = null,
    localizationTarget: String? = null,
    languagePackId: String? = null,
    key: String? = null
): TdLanguagePackStringValue = exec(TdGetLanguagePackString(languagePackDatabasePath,
        localizationTarget, languagePackId, key))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.language(f: TdGetLanguagePackInfo): TdLanguagePackInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLanguagePackInfo(languagePackId)",
            "dev.whyoleg.ktd.api.suspend.getLanguagePackInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLanguagePackInfo(languagePackId: String? = null): TdLanguagePackInfo =
        exec(TdGetLanguagePackInfo(languagePackId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.language(f: TdGetLanguagePackStrings): TdLanguagePackStrings = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getLanguagePackStrings(languagePackId, keys)",
            "dev.whyoleg.ktd.api.suspend.getLanguagePackStrings"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getLanguagePackStrings(languagePackId: String? = null, keys: List<String>
        = emptyList()): TdLanguagePackStrings = exec(TdGetLanguagePackStrings(languagePackId, keys))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.language(f: TdSynchronizeLanguagePack): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("synchronizeLanguagePack(languagePackId)",
            "dev.whyoleg.ktd.api.suspend.synchronizeLanguagePack"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.synchronizeLanguagePack(languagePackId: String? = null): TdOk =
        exec(TdSynchronizeLanguagePack(languagePackId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.language(f: TdDeleteLanguagePack): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteLanguagePack(languagePackId)",
            "dev.whyoleg.ktd.api.suspend.deleteLanguagePack"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteLanguagePack(languagePackId: String? = null): TdOk =
        exec(TdDeleteLanguagePack(languagePackId))
