package dev.whyoleg.ktd.cli.diff.builder

import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.diff.data.StringDiffChange.*

fun StringBuilder.withIndentPlus(block: StringBuilder.() -> Unit) {
    withIndent(indent = "", separator = "\n!+", prefix = "\n!+", block = block)
}

fun StringBuilder.withIndentMinus(block: StringBuilder.() -> Unit) {
    withIndent(indent = "", separator = "\n!-", prefix = "\n!-", block = block)
}

fun <T> List<T>.joinAdditions(buffer: StringBuilder, transform: ((T) -> String)? = null) {
    buffer.withIndentPlus {
        this@joinAdditions.joinTo(this, "\n", transform = transform)
    }
}

fun <T> List<T>.joinSubtractions(buffer: StringBuilder, transform: ((T) -> String)? = null) {
    buffer.withIndentMinus {
        this@joinSubtractions.joinTo(this, "\n", transform = transform)
    }
}

fun <T> List<T>.joinWithIndent(buffer: StringBuilder, transform: ((T) -> String)? = null) {
    buffer.withIndent(prefix = "\n") {
        this@joinWithIndent.joinTo(this, "\n", transform = transform)
    }
}

fun StringBuilder.typeDiff(text: String, type: TlTypeDiff) {
    append("\n").append(text)
    withIndentMinus { append(type.old) }
    withIndentPlus { append(type.new) }
}

fun StringBuilder.additionListDiff(additionList: TlAdditionListDiff) {
    append("\nAdditions:")
    additionList.removed?.joinSubtractions(this)
    additionList.added?.joinAdditions(this)
}

fun StringBuilder.descriptionDiff(list: List<StringDiff>) {
    append("\nDescription:")
    list.joinTo(this, "\n", prefix = "\n") {
        val prefix = when (it.change) {
            Removed  -> "!-"
            Added    -> "!+"
            NoChange -> "  "
        }
        prefix + it.value
    }
}
