package dev.whyoleg.ktd.cli.diff.algorithm

import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

inline fun <reified T : Any, D : Any> TlScheme.diff(new: TlScheme, diff: (old: List<T>, new: List<T>) -> D?): D? =
    diff(this.data.filterIsInstance<T>(), new.data.filterIsInstance<T>())

infix fun TlScheme.diff(new: TlScheme): TlSchemeDiff? = constructorDiff(
    diff(new, List<TlSealed>::diff),
    diff(new, List<TlObject>::diff),
    diff(new, List<TlFunction>::diff),
    ::TlSchemeDiff
)
