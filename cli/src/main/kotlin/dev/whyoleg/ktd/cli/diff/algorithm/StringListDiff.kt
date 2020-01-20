package dev.whyoleg.ktd.cli.diff.algorithm

import dev.whyoleg.ktd.cli.diff.data.*

infix fun List<String>.diff(new: List<String>): List<StringDiff>? {
    val oldMap = this.withIndex().associate { it.value to it.index }
    val newMap = new.withIndex().associate { it.value to it.index }
    val diff = oldMap diff newMap

    val added = diff.added.map(newMap::getValue)
    val removed = diff.removed.map(oldMap::getValue)
    val intersection = diff.intersection.map { oldMap.getValue(it) to newMap.getValue(it) }
    val noChange = intersection.filter { it.first == it.second }.map { it.first }
    val changed = intersection.filter { it.first != it.second }.map { it.second }

    val list = mutableListOf<StringDiff>()
    repeat(maxOf(this.size, new.size)) { i ->
        if (i in removed) list += StringDiff(this[i], StringDiffChange.Removed)
        if (i in added) list += StringDiff(new[i], StringDiffChange.Added)
        if (i in noChange) list += StringDiff(this[i], StringDiffChange.NoChange)
        if (i in changed) list += StringDiff(new[i], StringDiffChange.NoChange)
    }
    return if (list.all { it.change == StringDiffChange.NoChange }) null else list.takeIfIsNotEmpty()
}

