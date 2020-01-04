package dev.whyoleg.ktd.cli.diff.builder

import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*


private fun function(function: TlFunction): String = buildString {
    append(function.type).append("\n")
    withIndent {
        append("Returns: ").append(function.returnType)
        metadata(function.metadata)
    }
}

private fun change(function: TlFunctionDiff): String = buildString {
    append(function.type)
    withIndent {
        function.returnType?.let { typeDiff("Returns:", it) }
        function.metadata?.let(this::metadataDiff)
    }
}

fun StringBuilder.functionListDiff(functionList: TlFunctionListDiff) {
    append("\nFunctions:")
    functionList.removed?.joinSubtractions(this, TlFunction::type)
    functionList.added?.joinAdditions(this, ::function)
    functionList.changed?.joinWithIndent(this, ::change)
}
