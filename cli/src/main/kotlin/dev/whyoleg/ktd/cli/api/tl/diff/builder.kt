package dev.whyoleg.ktd.cli.api.tl.diff

import dev.whyoleg.ktd.cli.api.builder.*
import dev.whyoleg.ktd.cli.api.tl.*

fun StringBuilder.withIndentPlus(block: StringBuilder.() -> Unit) {
    withIndent(indent = "", separator = "\n!+", prefix = "!+", block = block)
}

fun StringBuilder.withIndentMinus(block: StringBuilder.() -> Unit) {
    withIndent(indent = "", separator = "\n!-", prefix = "!-", block = block)
}

fun StringBuilder.typeDiff(type: TlTypeDiff) {
    withIndentMinus { append(type.old) }
    append("\n")
    withIndentPlus { append(type.new) }
}

fun StringBuilder.additionListDiff(additionList: TlAdditionListDiff) {
    additionList.removed?.let {
        append("\n")
        withIndentMinus {
            it.joinTo(this, "\n")
        }
    }
    additionList.added?.let {
        append("\n")
        withIndentPlus {
            it.joinTo(this, "\n")
        }
    }
}

fun StringBuilder.propertyDiff(property: TlPropertyDiff) {
    append(property.name.snakeToCamel())
    withIndent {
        property.type?.let {
            append("\nType: ").append("\n")
            typeDiff(it)
        }
        property.additionList?.let {
            append("\nAdditions:")
            additionListDiff(it)
        }
    }
}

fun StringBuilder.property(property: TlProperty) {
    append(property.name.snakeToCamel()).append(": ").append(property.type.kotlinType)
    if (property.additions.isNotEmpty()) {
        withIndent {
            append("\nAdditions:\n")
            withIndent {
                property.additions.joinTo(this, "\n")
            }
        }
    }
}

fun StringBuilder.propertyListDiff(propertyList: TlPropertyListDiff) {
    propertyList.removed?.let {
        append("\n")
        withIndentMinus {
            it.joinTo(this, "\n") { "${it.name.snakeToCamel()}: ${it.type}" }
        }
    }
    propertyList.added?.let {
        append("\n")
        withIndentPlus {
            it.joinTo(this, "\n") { buildString { property(it) } }
        }
    }
    propertyList.changed?.let {
        append("\n")
        withIndent {
            it.joinTo(this, "\n") { buildString { propertyDiff(it) } }
        }
    }
}

fun StringBuilder.metadataDiff(metadata: TlMetadataDiff) {
    metadata.additionList?.let {
        append("\nAdditions:")
        additionListDiff(it)
    }
    metadata.propertyList?.let {
        append("\nProperties:")
        propertyListDiff(it)
    }
}

fun StringBuilder.metadata(metadata: TlMetadata) {
    if (metadata.additions.isNotEmpty()) {
        append("\nAdditions:\n")
        withIndent {
            metadata.additions.joinTo(this, "\n")
        }
    }
    if (metadata.properties.isNotEmpty()) {
        append("\nProperties:\n")
        withIndent {
            metadata.properties.joinTo(this, "\n") { buildString { property(it) } }
        }
    }
}

fun StringBuilder.abstractDiff(abstract: TlAbstractDiff) {
    append(abstract.type)
    abstract.metadata?.let {
        metadataDiff(it)
    }
}

fun StringBuilder.abstract(abstract: TlAbstract) {
    append(abstract.type)
    withIndent {
        metadata(abstract.metadata)
    }
}

fun StringBuilder.abstractListDiff(abstractList: TlAbstractListDiff) {
    abstractList.removed?.let {
        append("\n")
        withIndentMinus {
            it.joinTo(this, "\n", transform = TlAbstract::type)
        }
    }
    abstractList.added?.let {
        append("\n")
        withIndentPlus {
            it.joinTo(this, "\n") { buildString { abstract(it) } }
        }
    }
    abstractList.changed?.let {
        append("\n")
        withIndent {
            it.joinTo(this, "\n") { buildString { abstractDiff(it) } }
        }
    }
}

fun StringBuilder.objectDiff(obj: TlObjectDiff) {
    append(obj.type)
    withIndent {
        obj.parentType?.let {
            append("\nParent type:\n")
            typeDiff(it)
        }
        obj.metadata?.let {
            metadataDiff(it)
        }
    }
}

fun StringBuilder.obj(obj: TlObject) {
    append(obj.type)
    if (obj.parentType != "Object") append(" : ").append(obj.parentType)
    withIndent {
        metadata(obj.metadata)
    }
}

fun StringBuilder.objectListDiff(objectList: TlObjectListDiff) {
    objectList.removed?.let {
        append("\n")
        withIndentMinus {
            it.joinTo(this, "\n") {
                buildString {
                    append(it.type)
                    if (it.parentType != "Object") append(" : ").append(it.parentType)
                }
            }
        }
    }
    objectList.added?.let {
        append("\n")
        withIndentPlus {
            it.joinTo(this, "\n") { buildString { obj(it) } }
        }
    }
    objectList.changed?.let {
        append("\n")
        withIndent {
            it.joinTo(this, "\n") { buildString { objectDiff(it) } }
        }
    }
}

fun StringBuilder.functionDiff(function: TlFunctionDiff) {
    append(function.type)
    withIndent {
        function.returnType?.let {
            append("\nReturns: ").append("\n")
            typeDiff(it)
        }
        function.metadata?.let {
            metadataDiff(it)
        }
    }
}

fun StringBuilder.function(function: TlFunction) {
    append(function.type).append("\n")
    withIndent {
        append("Returns: ").append(function.returnType)
        metadata(function.metadata)
    }
}

fun StringBuilder.functionListDiff(functionList: TlFunctionListDiff) {
    functionList.removed?.let {
        append("\n")
        withIndentMinus {
            it.joinTo(this, "\n", transform = TlFunction::type)
        }
    }
    functionList.added?.let {
        append("\n")
        withIndentPlus {
            it.joinTo(this, "\n") { buildString { function(it) } }
        }
    }
    functionList.changed?.let {
        append("\n")
        withIndent {
            it.joinTo(this, "\n") { buildString { functionDiff(it) } }
        }
    }
}

fun StringBuilder.schemeDiff(scheme: TlSchemeDiff) {
    scheme.abstractList?.let {
        append("\nAbstract classes:")
        abstractListDiff(it)
    }
    scheme.objectList?.let {
        append("\nObjects:")
        objectListDiff(it)
    }
    scheme.functionList?.let {
        append("\nFunctions:")
        functionListDiff(it)
    }
}
