package dev.whyoleg.ktd.cli.diff.builder

import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

private fun simple(obj: TlObject): String = buildString {
    append(obj.type)
    if (obj.parentType != "Object") append(" : ").append(obj.parentType)
}

private fun full(obj: TlObject): String = buildString {
    append(simple(obj))
    withIndent {
        metadata(obj.metadata)
    }
}

private fun change(obj: TlObjectDiff): String = buildString {
    append(obj.type)
    withIndent {
        obj.parentType?.let { typeDiff("Parent type:", it) }
        obj.metadata?.let(this::metadataDiff)
    }
}

fun StringBuilder.objectListDiff(objectList: TlObjectListDiff) {
    append("\nObjects:")
    objectList.removed?.joinSubtractions(this, ::simple)
    objectList.added?.joinAdditions(this, ::full)
    objectList.changed?.joinWithIndent(this, ::change)
}
