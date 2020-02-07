package dev.whyoleg.ktd.cli.diff.algorithm

import dev.whyoleg.ktd.cli.diff.data.*

infix fun <T : Any> List<T>.listDiff(other: List<T>): List<T>? = (this - other).takeIfIsNotEmpty()

infix fun String?.typeDiff(new: String?): TlTypeDiff? = if (this == new) null else TlTypeDiff(this, new)
