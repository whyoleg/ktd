@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.custom

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.custom(f: TdAddCustomServerLanguagePack): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addCustomServerLanguagePack(languagePackId)",
            "dev.whyoleg.ktd.api.suspend.addCustomServerLanguagePack"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addCustomServerLanguagePack(languagePackId: String? = null): TdOk =
        exec(TdAddCustomServerLanguagePack(languagePackId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.custom(f: TdSetCustomLanguagePack): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setCustomLanguagePack(info, strings)",
            "dev.whyoleg.ktd.api.suspend.setCustomLanguagePack"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setCustomLanguagePack(info: TdLanguagePackInfo? = null,
        strings: List<TdLanguagePackString> = emptyList()): TdOk =
        exec(TdSetCustomLanguagePack(info, strings))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.custom(f: TdEditCustomLanguagePackInfo): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("editCustomLanguagePackInfo(info)",
            "dev.whyoleg.ktd.api.suspend.editCustomLanguagePackInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editCustomLanguagePackInfo(info: TdLanguagePackInfo? = null): TdOk =
        exec(TdEditCustomLanguagePackInfo(info))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.custom(f: TdSetCustomLanguagePackString): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setCustomLanguagePackString(languagePackId, newString)",
            "dev.whyoleg.ktd.api.suspend.setCustomLanguagePackString"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setCustomLanguagePackString(languagePackId: String? = null,
        newString: TdLanguagePackString? = null): TdOk =
        exec(TdSetCustomLanguagePackString(languagePackId, newString))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.custom(f: TdSendCustomRequest): TdCustomRequestResult = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendCustomRequest(method, parameters)",
            "dev.whyoleg.ktd.api.suspend.sendCustomRequest"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendCustomRequest(method: String? = null, parameters: String? = null):
        TdCustomRequestResult = exec(TdSendCustomRequest(method, parameters))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.custom(f: TdAnswerCustomQuery): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("answerCustomQuery(customQueryId, data)",
            "dev.whyoleg.ktd.api.suspend.answerCustomQuery"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.answerCustomQuery(customQueryId: Long = 0L, data: String? = null): TdOk =
        exec(TdAnswerCustomQuery(customQueryId, data))
