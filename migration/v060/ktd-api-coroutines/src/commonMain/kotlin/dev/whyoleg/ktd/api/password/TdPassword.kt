@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.password

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.password(f: TdGetPasswordState): TdPasswordState = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPasswordState()", "dev.whyoleg.ktd.api.suspend.getPasswordState"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPasswordState(): TdPasswordState = exec(TdGetPasswordState())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.password(f: TdSetPassword): TdPasswordState = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("setPassword(oldPassword, newPassword, newHint, setRecoveryEmailAddress, newRecoveryEmailAddress)",
            "dev.whyoleg.ktd.api.suspend.setPassword"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setPassword(
    oldPassword: String? = null,
    newPassword: String? = null,
    newHint: String? = null,
    setRecoveryEmailAddress: Boolean = false,
    newRecoveryEmailAddress: String? = null
): TdPasswordState = exec(TdSetPassword(oldPassword, newPassword, newHint, setRecoveryEmailAddress,
        newRecoveryEmailAddress))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.password(f: TdSetRecoveryEmailAddress): TdPasswordState = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setRecoveryEmailAddress(password, newRecoveryEmailAddress)",
            "dev.whyoleg.ktd.api.suspend.setRecoveryEmailAddress"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setRecoveryEmailAddress(password: String? = null,
        newRecoveryEmailAddress: String? = null): TdPasswordState =
        exec(TdSetRecoveryEmailAddress(password, newRecoveryEmailAddress))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.password(f: TdCheckRecoveryEmailAddressCode): TdPasswordState = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkRecoveryEmailAddressCode(code)",
            "dev.whyoleg.ktd.api.suspend.checkRecoveryEmailAddressCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkRecoveryEmailAddressCode(code: String? = null): TdPasswordState =
        exec(TdCheckRecoveryEmailAddressCode(code))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.password(f: TdResendRecoveryEmailAddressCode): TdPasswordState = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resendRecoveryEmailAddressCode()",
            "dev.whyoleg.ktd.api.suspend.resendRecoveryEmailAddressCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resendRecoveryEmailAddressCode(): TdPasswordState =
        exec(TdResendRecoveryEmailAddressCode())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.password(f: TdRecoverPassword): TdPasswordState = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("recoverPassword(recoveryCode)",
            "dev.whyoleg.ktd.api.suspend.recoverPassword"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.recoverPassword(recoveryCode: String? = null): TdPasswordState =
        exec(TdRecoverPassword(recoveryCode))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.password(f: TdCreateTemporaryPassword): TdTemporaryPasswordState =
        exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createTemporaryPassword(password, validFor)",
            "dev.whyoleg.ktd.api.suspend.createTemporaryPassword"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createTemporaryPassword(password: String? = null, validFor: Int = 0):
        TdTemporaryPasswordState = exec(TdCreateTemporaryPassword(password, validFor))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.password(f: TdGetTemporaryPasswordState): TdTemporaryPasswordState =
        exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getTemporaryPasswordState()",
            "dev.whyoleg.ktd.api.suspend.getTemporaryPasswordState"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getTemporaryPasswordState(): TdTemporaryPasswordState =
        exec(TdGetTemporaryPasswordState())
