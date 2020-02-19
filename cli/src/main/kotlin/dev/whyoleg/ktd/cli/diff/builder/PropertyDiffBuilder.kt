package dev.whyoleg.ktd.cli.diff.builder

import dev.whyoleg.ktd.cli.*
import dev.whyoleg.ktd.cli.diff.algorithm.*
import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

private fun simple(property: TlProperty): String = "${property.name.snakeToCamel()}: ${property.type}"

internal fun property(property: TlProperty): String = buildString {
    append(simple(property))
    withIndent {
        property.descriptions.takeIfIsNotEmpty()?.let {
            append("\nDescription:")
            it.joinWithIndent(this)
        }
        property.additions.takeIfIsNotEmpty()?.let {
            append("\nAdditions:")
            it.joinWithIndent(this)
        }
    }
}

private fun change(property: TlPropertyDiff): String = buildString {
    append(property.name.snakeToCamel())
    withIndent {
        property.type?.let { typeDiff("Type:", it) }
        property.descriptionList?.let(this::descriptionDiff)
        property.additionList?.let(this::additionListDiff)
    }
}


fun StringBuilder.propertyListDiff(propertyList: TlPropertyListDiff) {
    append("\nProperties:")
    propertyList.removed?.joinSubtractions(this, ::simple)
    propertyList.added?.joinAdditions(this, ::property)
    propertyList.changed?.joinWithIndent(this, ::change)
}
