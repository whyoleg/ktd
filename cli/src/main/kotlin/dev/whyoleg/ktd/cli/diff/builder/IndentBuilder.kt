package dev.whyoleg.ktd.cli.diff.builder

fun StringBuilder.withIndent(
    indent: String = "  ",
    separator: String = "\n",
    prefix: String = "",
    postfix: String = "",
    block: StringBuilder.() -> Unit
) {
    buildString(block).split("\n").joinTo(this, separator, prefix, postfix) {
        if (it.isBlank() && indent.isBlank()) ""
        else indent + it
    }
}
