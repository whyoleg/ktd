package dev.whyoleg.ktd.cli.diff.builder

import dev.whyoleg.ktd.cli.diff.algorithm.*
import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

infix fun TlScheme.stringDiff(new: TlScheme): String? = (this diff new)?.schemeDiff()

fun TlSchemeDiff.schemeDiff(): String = buildString {
    append("```diff")
    sealedList?.let(this::sealedListDiff)
    objectList?.let(this::objectListDiff)
    functionList?.let(this::functionListDiff)
    append("\n```\n")
}.arrangeDiff()

private fun String.arrangeDiff(): String = split("\n").joinToString("\n") {
    val p = it.indexOf("!+")
    val m = it.indexOf("!-")
    when {
        p != -1 -> it.replaceRange(0, p + 2, "+" + " ".repeat(p + 1))
        m != -1 -> it.replaceRange(0, m + 2, "-" + " ".repeat(m + 1))
        else    -> it
    }
}
