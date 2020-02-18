package dev.whyoleg.ktd.cli.diff.algorithm

import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

fun <T : Any> List<T>.takeIfIsNotEmpty(): List<T>? = takeIf(List<T>::isNotEmpty)

inline fun <T : Any, ED : Any, D : Any> List<T>.diff(
    new: List<T>,
    keySelector: (T) -> String,
    elementDiff: (old: T, new: T) -> D?,
    resultDiff: (added: List<T>?, removed: List<T>?, changed: List<D>?) -> ED
): ED? {
    val oldMap = this.associateBy(keySelector)
    val newMap = new.associateBy(keySelector)
    val keys = oldMap diff newMap
    val diff = oldMap.diff(newMap, keys, elementDiff)
    val added = new.filter { keySelector(it) in keys.added }.takeIfIsNotEmpty()
    val removed = this.filter { keySelector(it) in keys.removed }.takeIfIsNotEmpty()
    return if (added == null && removed == null && diff == null) null else resultDiff(added, removed, diff)
}

infix fun List<TlSealed>.diff(new: List<TlSealed>): TlSealedListDiff? =
    diff(new, TlSealed::type, TlSealed::diff, ::TlSealedListDiff)

infix fun List<TlObject>.diff(new: List<TlObject>): TlObjectListDiff? =
    diff(new, TlObject::type, TlObject::diff, ::TlObjectListDiff)

infix fun List<TlFunction>.diff(new: List<TlFunction>): TlFunctionListDiff? =
    diff(new, TlFunction::type, TlFunction::diff, ::TlFunctionListDiff)

infix fun List<TlProperty>.diff(new: List<TlProperty>): TlPropertyListDiff? =
    diff(new, TlProperty::name, TlProperty::diff, ::TlPropertyListDiff)
