@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.contact

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.contact(f: TdAddContact): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addContact(contact, sharePhoneNumber)",
            "dev.whyoleg.ktd.api.suspend.addContact"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addContact(contact: TdContact? = null, sharePhoneNumber: Boolean =
        false): TdOk = exec(TdAddContact(contact, sharePhoneNumber))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.contact(f: TdImportContacts): TdImportedContacts = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("importContacts(contacts)",
            "dev.whyoleg.ktd.api.suspend.importContacts"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.importContacts(contacts: List<TdContact> = emptyList()):
        TdImportedContacts = exec(TdImportContacts(contacts))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.contact(f: TdRemoveContacts): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeContacts(userIds)",
            "dev.whyoleg.ktd.api.suspend.removeContacts"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeContacts(userIds: IntArray = intArrayOf()): TdOk =
        exec(TdRemoveContacts(userIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.contact(f: TdGetImportedContactCount): TdCount = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getImportedContactCount()",
            "dev.whyoleg.ktd.api.suspend.getImportedContactCount"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getImportedContactCount(): TdCount = exec(TdGetImportedContactCount())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.contact(f: TdChangeImportedContacts): TdImportedContacts = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("changeImportedContacts(contacts)",
            "dev.whyoleg.ktd.api.suspend.changeImportedContacts"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.changeImportedContacts(contacts: List<TdContact> = emptyList()):
        TdImportedContacts = exec(TdChangeImportedContacts(contacts))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.contact(f: TdClearImportedContacts): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("clearImportedContacts()",
            "dev.whyoleg.ktd.api.suspend.clearImportedContacts"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.clearImportedContacts(): TdOk = exec(TdClearImportedContacts())
