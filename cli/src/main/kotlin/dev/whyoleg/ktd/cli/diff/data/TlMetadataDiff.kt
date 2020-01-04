package dev.whyoleg.ktd.cli.diff.data

data class TlMetadataDiff(
    val descriptionList: List<StringDiff>?,
    val additionList: TlAdditionListDiff?,
    val propertyList: TlPropertyListDiff?
)
