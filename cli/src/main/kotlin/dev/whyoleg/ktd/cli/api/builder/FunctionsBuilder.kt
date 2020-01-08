package dev.whyoleg.ktd.cli.api.builder

import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.tl.*

private val customMapping = mapOf(
    "SetName" to "User",
    "SetBio" to "User",
    "DeleteSavedCredentials" to "Payment",
    "GetPushReceiverId" to "Notification"
)

private val ignoredTypes = setOf(
    "T",
    "Ok",
    "Top",
    "Basic",
    "Chats",
    "Count",
    "Error",
    "Formatted",
    "Found",
    "Http",
    "Imported",
    "Messages",
    "Public",
    "Push",
    "Recovery",
    "Saved",
    "Scope",
    "Seconds",
    "Sessions",
    "Stickers",
    "Temporary",
    "Update",
    "Users",
    "Animations",
    "Backgrounds",
    "Draft",
    "Emojis",
    "Hashtags",
    "Send"
)

private val additionalTypes = setOf("Emoji", "Group", "Hashtag")

private val comporator = Comparator<Pair<String, Int>> { t1, t2 ->
    when (val c1 = t1.second.compareTo(t2.second)) {
        0    -> t2.first.length.compareTo(t1.first.length)
        else -> c1
    }
}

fun Iterable<String>.findByType(type: String): String? =
    map { it to type.indexOf(it) }
        .filter { it.second != -1 }
        .sortedWith(comporator)
        .firstOrNull()
        ?.first

fun List<TlData>.types(): List<String> =
    filter { it is TlObject || it is TlAbstract }
        .map { it.type.decapitalize().takeWhile(Char::isLowerCase).capitalize() }
        .distinct()

fun List<TlData>.groupFunctions(): Map<String, List<TlFunction>> {
    val types = (types() - ignoredTypes + additionalTypes).sorted().toSet()
    return filterIsInstance<TlFunction>().map { it to (it.type.capitalize() to it.returnType.capitalize()) }
        .groupBy { (_, pair) ->
            val (funcType, returnType) = pair
            val type = customMapping[funcType]
                ?: types.findByType(returnType)
                ?: types.findByType(funcType)
                ?: "Util"
            type
        }
        .mapValues { (_, list) -> list.map { it.first } }
}

fun StringBuilder.buildRawFunction(rawType: String, function: TlFunction) {
    buildDescription(function.descriptions())
    buildAnnotations(function.metadata.additions)
    append("suspend fun TelegramClient.").append(rawType.decapitalize())
    withRoundBrackets {
        append("f: ").append(function.type.capitalize())
    }
    val returnType = function.returnType.capitalize()
    append(": ").append(returnType).append(" = exec(f) as ").append(returnType)
    append("\n")
}

fun StringBuilder.buildFunctionWithParams(rawType: String, function: TlFunction, metadata: TlDataMetadata) {
    buildDescription(function.descriptionsWithProperties())
    buildAnnotations(function.metadata.additions)
    append("suspend fun TelegramClient.").append(function.type.decapitalize())
    buildParameters(function.metadata.properties.map { it.toParameter(metadata) }, addEmptyBrackets = true)
    append(": ").append(function.returnType.capitalize()).append(" = ").append(rawType.decapitalize())
    withRoundBrackets {
        append(function.type.capitalize())
        if (function.metadata.properties.isNotEmpty()) withRoundBrackets {
            function.metadata.properties.joinTo(this, ",\n") { it.name.snakeToCamel() }
        } else append("()")
    }
    append("\n")
}

fun StringBuilder.buildHeader(type: String) {
    suppress("unused")
    useExperimentalAnnotationsForFile()
    append("\n")
    buildPackage("api", type.toLowerCase())
    append("\n")
    buildImport()
    buildImport("api")
    buildImport("api", "TdApi")
}

fun StringBuilder.buildFunction(type: String, function: TlFunction, metadata: TlSchemeMetadata) {
    buildHeader(type)
    append("\n")
    buildFunctionWithParams(type, function, metadata[function])
    append("\n")
    buildRawFunction(type, function)
}
