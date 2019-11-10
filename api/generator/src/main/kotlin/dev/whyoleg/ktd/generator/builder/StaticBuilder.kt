package dev.whyoleg.ktd.generator.builder

import dev.whyoleg.ktd.generator.tl.*

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

fun StringBuilder.buildSyncFunction(function: TlFunction, metadata: TlDataMetadata) {
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

fun StringBuilder.buildRawSyncFunctions(functions: List<TlFunction>) {
    buildHeader("sync")
    functions.forEach {
        append("\n")
        buildRawSyncFunction(it)
    }
}

fun StringBuilder.buildSyncFunctions(functions: List<TlFunction>, metadata: TlSchemeMetadata) {
    buildHeader("sync")
    functions.forEach {
        append("\n")
        buildSyncFunction(it, metadata[it])
    }
}
