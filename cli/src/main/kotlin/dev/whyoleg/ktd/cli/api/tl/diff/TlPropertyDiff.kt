package dev.whyoleg.ktd.cli.api.tl.diff

import dev.whyoleg.ktd.cli.api.tl.*

data class TlTypeDiff(
    val old: String,
    val new: String
)

data class TlAdditionListDiff(
    val added: List<TlAddition>?,
    val removed: List<TlAddition>?
)

data class TlPropertyDiff(
    val name: String,
    val type: TlTypeDiff?,
    val additionList: TlAdditionListDiff?
)

data class TlPropertyListDiff(
    val added: List<TlProperty>?,
    val removed: List<TlProperty>?,
    val changed: List<TlPropertyDiff>?
)

data class TlMetadataDiff(
    val additionList: TlAdditionListDiff?,
    val propertyList: TlPropertyListDiff?
)

data class TlAbstractDiff(
    val type: String,
    val metadata: TlMetadataDiff?
)

data class TlAbstractListDiff(
    val added: List<TlAbstract>?,
    val removed: List<TlAbstract>?,
    val changed: List<TlAbstractDiff>?
)

data class TlObjectDiff(
    val type: String,
    val parentType: TlTypeDiff?,
    val metadata: TlMetadataDiff?
)

data class TlObjectListDiff(
    val added: List<TlObject>?,
    val removed: List<TlObject>?,
    val changed: List<TlObjectDiff>?
)

data class TlFunctionDiff(
    val type: String,
    val returnType: TlTypeDiff?,
    val metadata: TlMetadataDiff?
)

data class TlFunctionListDiff(
    val added: List<TlFunction>?,
    val removed: List<TlFunction>?,
    val changed: List<TlFunctionDiff>?
)

data class TlSchemeDiff(
    val abstractList: TlAbstractListDiff?,
    val objectList: TlObjectListDiff?,
    val functionList: TlFunctionListDiff?
)
