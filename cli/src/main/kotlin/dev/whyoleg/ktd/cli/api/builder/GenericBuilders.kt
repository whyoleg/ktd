package dev.whyoleg.ktd.cli.api.builder

import dev.whyoleg.ktd.cli.api.tl.*

const val group = "dev.whyoleg.ktd"
const val tabIndent = "  "
const val doubleTabIndent = "    "

fun StringBuilder.suppress(vararg suppressed: String) {
    append("@file:Suppress")
    withRoundBrackets {
        suppressed.joinTo(this, ",\n") { "\"$it\"" }
    }
    append("\n")
}

fun StringBuilder.buildImport(vararg packages: String) {
    append("import ").append(group)
    if (packages.isNotEmpty()) packages.joinTo(this, ".", ".", ".*\n", transform = String::trim)
    else append(".*\n")
}

fun StringBuilder.buildPackage(vararg packages: String) {
    append("package ").append(group)
    if (packages.isNotEmpty()) packages.joinTo(this, ".", ".", "\n", transform = String::trim)
    else append("\n")
}

fun StringBuilder.buildTypealias(from: String, to: String) {
    append("typealias ").append(from.trim()).append(" = ").append(to.trim()).append("\n")
}


fun StringBuilder.withIndent(
    indent: String = tabIndent,
    separator: String = "\n",
    prefix: String = "",
    postfix: String = "",
    block: StringBuilder.() -> Unit
) {
    buildString(block).split("\n").joinTo(this, separator, prefix, postfix) {
        if (it.isBlank() && indent.isBlank()) emptyToken
        else indent + it
    }
}

fun StringBuilder.withBrackets(
    start: String,
    end: String,
    indent: String = doubleTabIndent,
    newLine: Boolean = true,
    block: StringBuilder.() -> Unit
) {
    append(start).append("\n")
    withIndent(indent, postfix = "\n", block = block)
    append(end)
    if (newLine) append("\n")
}

fun StringBuilder.withCurlyBrackets(block: StringBuilder.() -> Unit) {
    withBrackets("{", "}", block = block)
}

fun StringBuilder.withRoundBrackets(block: StringBuilder.() -> Unit) {
    withBrackets("(", ")", newLine = false, block = block)
}

fun StringBuilder.buildDescription(lines: List<String>) {
    withBrackets("/**", " */", " *") {
        lines.joinTo(this, "\n") {
            if (it.isBlank()) emptyToken
            else spaceToken + it
        }
    }
}

fun List<TlAddition>.strings(): List<String> = filterIsInstance<TlAddition.WithMessage>().mapNotNull(TlAddition.WithMessage::message)
