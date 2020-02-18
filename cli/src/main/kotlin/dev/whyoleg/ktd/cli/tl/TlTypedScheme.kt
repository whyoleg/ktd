package dev.whyoleg.ktd.cli.tl

import dev.whyoleg.ktd.cli.tl.parser.*

data class TlTypedScheme(
    val data: List<TlData>,
    val sealed: Map<TlSealed, List<TlSealedChild>>,
    val objects: List<TlObject>,
    val functions: List<TlFunction>,
    val updates: List<TlUpdates>,
    val responseTypes: Set<String>,
    val requestTypes: Map<String, String>
)

fun List<TlData>.typed(responseTypes: Set<String>, requestTypes: Map<String, String>): TlTypedScheme {
    val sealedChildren = filterIsInstance<TlSealedChild>()
    return TlTypedScheme(
        this,
        filterIsInstance<TlSealed>().associateWith { sealed -> sealedChildren.filter { it.parentType == sealed.type } },
        filterIsInstance<TlObject>(),
        filterIsInstance<TlFunction>(),
        sealedChildren.filter { it.parentType == "Update" }.splitUpdates(),
        responseTypes,
        requestTypes
    )
}

private val existed = listOf("Ok", "Error", "Close", "Destroy", "LogOut", "Update")

fun parseData(tdBytes: ByteArray, tlBytes: ByteArray): Map<TlKind, TlTypedScheme> {
    val map = tdBytes.parseTdCpp()
    val scheme = tlBytes.parseScheme().data

    val botsKeys = map.filter { it.value == TlKind.Bots }.keys
    val userKeys = map.filter { it.value == TlKind.User }.keys

    val requestTypes: Map<String, String> = scheme.filterIsInstance<TlFunction>().associate { it.type to it.returnType }
    val responseTypes: Set<String> = requestTypes.values.toSet()

    return scheme.groupBy {
        when {
            it.type in existed                                                  -> TlKind.BuiltIn
            TlAddition.TestOnly in it.metadata.additions                        -> TlKind.Test
            it.type in botsKeys || TlAddition.BotsOnly in it.metadata.additions -> TlKind.Bots
            it.type in userKeys                                                 -> TlKind.User
            else                                                                -> TlKind.Core
        }
    }.mapValues { (_, list) -> list.typed(responseTypes, requestTypes) }
}
