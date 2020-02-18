package dev.whyoleg.ktd.cli.tl.parser

import dev.whyoleg.ktd.cli.tl.*

private const val userOnly = "CHECK_IS_USER();"
private const val botsOnly = "CHECK_IS_BOT();"

private val regex = "void Td::on_request\\(.*td_api::(.*) &request\\).*".toRegex()

fun ByteArray.parseTdCpp(): Map<String, TlKind?> {
    val lines = inputStream().reader().readLines()
    return lines.foldIndexed(mutableMapOf()) { index, acc, line ->
        regex.find(line)?.groups?.get(1)?.also {
            val kindLine = lines[index + 1]
            acc[it.value.capitalize()] = when {
                userOnly in kindLine -> TlKind.User
                botsOnly in kindLine -> TlKind.Bots
                else                 -> null
            }
        }
        acc
    }
}
