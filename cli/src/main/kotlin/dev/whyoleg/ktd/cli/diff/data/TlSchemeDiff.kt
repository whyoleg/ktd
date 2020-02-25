package dev.whyoleg.ktd.cli.diff.data

data class TlSchemeDiff(
    val sealedList: TlSealedListDiff?,
    val objectList: TlObjectListDiff?,
    val functionList: TlFunctionListDiff?
)
