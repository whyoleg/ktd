package dev.whyoleg.ktd.cli.diff.algorithm

inline fun <R : Any, D1, D2> constructorDiff(diff1: D1, diff2: D2, constructor: (D1, D2) -> R): R? =
    if (diff1 == null && diff2 == null) null else constructor(diff1, diff2)

inline fun <R : Any, D1, P1> constructorDiff(diff1: D1, constructor: (P1, D1) -> R, param1: P1): R? =
    if (diff1 == null) null else constructor(param1, diff1)

inline fun <R : Any, D1, D2, P1> constructorDiff(diff1: D1, diff2: D2, constructor: (P1, D1, D2) -> R, param1: P1): R? =
    if (diff1 == null && diff2 == null) null else constructor(param1, diff1, diff2)

inline fun <R : Any, D1, D2, D3> constructorDiff(diff1: D1, diff2: D2, diff3: D3, constructor: (D1, D2, D3) -> R): R? =
    if (diff1 == null && diff2 == null && diff3 == null) null else constructor(diff1, diff2, diff3)

inline fun <R : Any, D1, D2, D3, P1> constructorDiff(diff1: D1, diff2: D2, diff3: D3, constructor: (P1, D1, D2, D3) -> R, param1: P1): R? =
    if (diff1 == null && diff2 == null && diff3 == null) null else constructor(param1, diff1, diff2, diff3)
