package dev.whyoleg.ktd.cli.api.builder

import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.tl.*

fun StringBuilder.buildRawSyncFunction(function: TlFunction) {
    buildDescription(function.descriptions())
    buildAnnotations(function.metadata.additions)
    append("fun TelegramClient.Companion.execute")
    withRoundBrackets {
        append("f: ").append(function.type.capitalize())
    }
    val returnType = function.returnType.capitalize()
    append(": ").append(returnType).append(" = exec(f) as ").append(returnType)
    append("\n")
}

fun StringBuilder.buildSyncFunctionWithParams(function: TlFunction, metadata: TlDataMetadata) {
    buildDescription(function.descriptionsWithProperties())
    buildAnnotations(function.metadata.additions)
    append("fun TelegramClient.Companion.").append(function.type.decapitalize())
    buildParameters(function.metadata.properties.map { it.toParameter(metadata) }, addEmptyBrackets = true)
    append(": ").append(function.returnType.capitalize()).append(" = execute")
    withRoundBrackets {
        append(function.type.capitalize())
        if (function.metadata.properties.isNotEmpty()) withRoundBrackets {
            function.metadata.properties.joinTo(this, ",\n") { it.name.snakeToCamel() }
        } else append("()")
    }
    append("\n")
}

fun StringBuilder.buildSyncFunction(function: TlFunction, metadata: TlSchemeMetadata) {
    buildHeader("sync")
    append("\n")
    buildSyncFunctionWithParams(function, metadata[function])
    append("\n")
    buildRawSyncFunction(function)
}
