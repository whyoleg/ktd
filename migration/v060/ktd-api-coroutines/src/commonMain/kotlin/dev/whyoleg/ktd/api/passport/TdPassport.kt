@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.passport

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.passport(f: TdGetPassportElement): TdPassportElement = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPassportElement(type, password)",
            "dev.whyoleg.ktd.api.suspend.getPassportElement"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPassportElement(type: TdPassportElementType? = null, password: String?
        = null): TdPassportElement = exec(TdGetPassportElement(type, password))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.passport(f: TdGetAllPassportElements): TdPassportElements = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getAllPassportElements(password)",
            "dev.whyoleg.ktd.api.suspend.getAllPassportElements"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getAllPassportElements(password: String? = null): TdPassportElements =
        exec(TdGetAllPassportElements(password))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.passport(f: TdSetPassportElement): TdPassportElement = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setPassportElement(element, password)",
            "dev.whyoleg.ktd.api.suspend.setPassportElement"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setPassportElement(element: TdInputPassportElement? = null,
        password: String? = null): TdPassportElement = exec(TdSetPassportElement(element, password))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.passport(f: TdDeletePassportElement): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deletePassportElement(type)",
            "dev.whyoleg.ktd.api.suspend.deletePassportElement"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deletePassportElement(type: TdPassportElementType? = null): TdOk =
        exec(TdDeletePassportElement(type))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.passport(f: TdSetPassportElementErrors): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setPassportElementErrors(userId, errors)",
            "dev.whyoleg.ktd.api.suspend.setPassportElementErrors"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setPassportElementErrors(userId: Int = 0,
        errors: List<TdInputPassportElementError> = emptyList()): TdOk =
        exec(TdSetPassportElementErrors(userId, errors))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.passport(f: TdGetPassportAuthorizationForm): TdPassportAuthorizationForm
        = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPassportAuthorizationForm(botUserId, scope, publicKey, nonce)",
            "dev.whyoleg.ktd.api.suspend.getPassportAuthorizationForm"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPassportAuthorizationForm(
    botUserId: Int = 0,
    scope: String? = null,
    publicKey: String? = null,
    nonce: String? = null
): TdPassportAuthorizationForm = exec(TdGetPassportAuthorizationForm(botUserId, scope, publicKey,
        nonce))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.passport(f: TdGetPassportAuthorizationFormAvailableElements):
        TdPassportElementsWithErrors = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("getPassportAuthorizationFormAvailableElements(autorizationFormId, password)",
            "dev.whyoleg.ktd.api.suspend.getPassportAuthorizationFormAvailableElements"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPassportAuthorizationFormAvailableElements(autorizationFormId: Int =
        0, password: String? = null): TdPassportElementsWithErrors =
        exec(TdGetPassportAuthorizationFormAvailableElements(autorizationFormId, password))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.passport(f: TdSendPassportAuthorizationForm): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendPassportAuthorizationForm(autorizationFormId, types)",
            "dev.whyoleg.ktd.api.suspend.sendPassportAuthorizationForm"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendPassportAuthorizationForm(autorizationFormId: Int = 0,
        types: List<TdPassportElementType> = emptyList()): TdOk =
        exec(TdSendPassportAuthorizationForm(autorizationFormId, types))
