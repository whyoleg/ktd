package dev.whyoleg.ktd.cli.tl

data class TlUpdates(val group: String?, val children: List<TlSealedChild>)

private val updatesKeys = listOf("User", "Chat", "Message", "Unread", "Supergroup", "BasicGroup", "FileGeneration")

fun List<TlSealedChild>.splitUpdates(): List<TlUpdates> {
    val groups =
        updatesKeys.map { key ->
            key to filter {
                (it.type.startsWith("Update$key") || it.type.startsWith("UpdateNew$key")) &&
                        it.type.substringAfter(key).let { it.firstOrNull()?.isUpperCase() ?: true }
            }
        }.filter { it.second.isNotEmpty() }
    val groupsValues = groups.flatMap { it.second.map(TlSealedChild::type) }.toSet()
    return groups.map { TlUpdates(it.first, it.second) } + TlUpdates(null, filter { it.type !in groupsValues })
}