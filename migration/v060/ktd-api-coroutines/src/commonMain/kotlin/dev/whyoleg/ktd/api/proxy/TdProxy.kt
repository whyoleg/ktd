@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.proxy

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.proxy(f: TdAddProxy): TdProxy = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addProxy(server, port, enable, type)",
            "dev.whyoleg.ktd.api.suspend.addProxy"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addProxy(
    server: String? = null,
    port: Int = 0,
    enable: Boolean = false,
    type: TdProxyType? = null
): TdProxy = exec(TdAddProxy(server, port, enable, type))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.proxy(f: TdEditProxy): TdProxy = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("editProxy(proxyId, server, port, enable, type)",
            "dev.whyoleg.ktd.api.suspend.editProxy"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editProxy(
    proxyId: Int = 0,
    server: String? = null,
    port: Int = 0,
    enable: Boolean = false,
    type: TdProxyType? = null
): TdProxy = exec(TdEditProxy(proxyId, server, port, enable, type))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.proxy(f: TdEnableProxy): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("enableProxy(proxyId)", "dev.whyoleg.ktd.api.suspend.enableProxy"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.enableProxy(proxyId: Int = 0): TdOk = exec(TdEnableProxy(proxyId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.proxy(f: TdDisableProxy): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("disableProxy()", "dev.whyoleg.ktd.api.suspend.disableProxy"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.disableProxy(): TdOk = exec(TdDisableProxy())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.proxy(f: TdRemoveProxy): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeProxy(proxyId)", "dev.whyoleg.ktd.api.suspend.removeProxy"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeProxy(proxyId: Int = 0): TdOk = exec(TdRemoveProxy(proxyId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.proxy(f: TdPingProxy): TdSeconds = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("pingProxy(proxyId)", "dev.whyoleg.ktd.api.suspend.pingProxy"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.pingProxy(proxyId: Int = 0): TdSeconds = exec(TdPingProxy(proxyId))
