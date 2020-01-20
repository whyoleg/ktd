package dev.whyoleg.ktd.cli.diff.data

data class TlSchemeDiff(
    val abstractList: TlAbstractListDiff?,
    val objectList: TlObjectListDiff?,
    val functionList: TlFunctionListDiff?
)
