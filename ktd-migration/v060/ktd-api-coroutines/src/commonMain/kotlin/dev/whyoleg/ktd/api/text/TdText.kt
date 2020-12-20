@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.text

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdGetTextEntities): TdTextEntities = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getTextEntities(text)",
            "dev.whyoleg.ktd.api.suspend.getTextEntities"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getTextEntities(text: String? = null): TdTextEntities =
        exec(TdGetTextEntities(text))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdParseTextEntities): TdFormattedText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("parseTextEntities(text, parseMode)",
            "dev.whyoleg.ktd.api.suspend.parseTextEntities"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.parseTextEntities(text: String? = null, parseMode: TdTextParseMode? =
        null): TdFormattedText = exec(TdParseTextEntities(text, parseMode))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdGetFileMimeType): TdText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getFileMimeType(fileName)",
            "dev.whyoleg.ktd.api.suspend.getFileMimeType"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getFileMimeType(fileName: String? = null): TdText =
        exec(TdGetFileMimeType(fileName))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdGetFileExtension): TdText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getFileExtension(mimeType)",
            "dev.whyoleg.ktd.api.suspend.getFileExtension"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getFileExtension(mimeType: String? = null): TdText =
        exec(TdGetFileExtension(mimeType))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdCleanFileName): TdText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("cleanFileName(fileName)",
            "dev.whyoleg.ktd.api.suspend.cleanFileName"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.cleanFileName(fileName: String? = null): TdText =
        exec(TdCleanFileName(fileName))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdGetJsonString): TdText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getJsonString(jsonValue)",
            "dev.whyoleg.ktd.api.suspend.getJsonString"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getJsonString(jsonValue: TdJsonValue? = null): TdText =
        exec(TdGetJsonString(jsonValue))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdGetPreferredCountryLanguage): TdText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPreferredCountryLanguage(countryCode)",
            "dev.whyoleg.ktd.api.suspend.getPreferredCountryLanguage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPreferredCountryLanguage(countryCode: String? = null): TdText =
        exec(TdGetPreferredCountryLanguage(countryCode))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdGetCountryCode): TdText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getCountryCode()", "dev.whyoleg.ktd.api.suspend.getCountryCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getCountryCode(): TdText = exec(TdGetCountryCode())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdGetInviteText): TdText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getInviteText()", "dev.whyoleg.ktd.api.suspend.getInviteText"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getInviteText(): TdText = exec(TdGetInviteText())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.text(f: TdGetProxyLink): TdText = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getProxyLink(proxyId)", "dev.whyoleg.ktd.api.suspend.getProxyLink"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getProxyLink(proxyId: Int = 0): TdText = exec(TdGetProxyLink(proxyId))
