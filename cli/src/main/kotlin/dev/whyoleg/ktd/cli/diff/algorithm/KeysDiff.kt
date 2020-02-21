package dev.whyoleg.ktd.cli.diff.algorithm

import dev.whyoleg.ktd.cli.*

data class KeysDiff(val added: Set<String>, val removed: Set<String>, val intersection: Set<String>)

infix fun Map<String, *>.diff(new: Map<String, *>): KeysDiff {
    val oldKeys = this.keys
    val newKeys = new.keys
    val addedKeys = newKeys - oldKeys
    val removedKeys = oldKeys - newKeys
    val intersectionKeys = oldKeys intersect newKeys
    return KeysDiff(addedKeys, removedKeys, intersectionKeys)
}

inline fun <T : Any, D : Any> Map<String, T>.diff(new: Map<String, T>, keys: KeysDiff, diff: (old: T, new: T) -> D?): List<D>? =
    keys.intersection.mapNotNull { diff(getValue(it), new.getValue(it)) }.takeIfIsNotEmpty()
