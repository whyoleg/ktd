package dev.whyoleg.ktd.cli.tl.parser

import dev.whyoleg.ktd.cli.tl.*

fun List<String>.parseTlData(): List<TlData> = parseRawTlData().map(RawTlData::toTlData)

private fun List<String>.parseRawTlData(): List<RawTlData> {
    var isFunction = false
    val data = mutableListOf<RawTlData>()
    val accumulator = mutableListOf(mutableListOf<String>())
    forEach {
        if (it == functionsToken) {
            isFunction = true
        } else {
            val lastList = accumulator.last()
            if (it.first().isLetter()) {
                val type = if (isFunction) RawTlDataType.Function else RawTlDataType.Object
                data += RawTlData(type, lastList, it)
                accumulator += mutableListOf<String>()
            } else lastList += it.substringAfter(addressToken)
        }
    }
    return data
}

private fun RawTlData.toTlData(): TlData = when (type) {
    RawTlDataType.Object   -> when (expression.contains(spaceToken)) {
        true  -> toClass()
        false -> toSealed()
    }
    RawTlDataType.Function -> toFunction()
}

private fun RawTlData.toSealed(): TlSealed {
    val map = groupLines()
    val (descriptions, additions) = map.splitByKey(descriptionToken)
    val metadata = TlMetadata(descriptions, additions, emptyList())
    return TlSealed(expression, metadata)
}

private fun RawTlData.toClass(): TlClass {
    val type = expression.substringBefore(spaceToken).trim().capitalize()
    val expressionParentType = expression.substringAfter(equalToken).trim()
    val metadata = extractMetadata()
    return when (expressionParentType) {
        type -> TlObject(type, metadata)
        else -> TlSealedChild(type, expressionParentType, metadata)
    }
}

private fun RawTlData.toFunction(): TlFunction {
    val type = expression.substringBefore(spaceToken).trim().capitalize()
    val returnType = expression.substringAfter(equalToken).trim()
    val metadata = extractMetadata()
    return TlFunction(type, returnType, metadata)
}

private fun RawTlData.extractMetadata(): TlMetadata {
    val map = groupLines()
    val (descriptions, additions) = map.splitByKey(descriptionToken)
    val propertiesString = expression.substringAfter(spaceToken).substringBefore(equalToken).trim()
    val properties = if (propertiesString.isBlank()) emptyList()
    else propertiesString.split(spaceToken).map { propertyDefinition ->
        val (name, type) = propertyDefinition.split(":")
        val key = if (name == descriptionToken) descriptionParamToken else name
        val (propDescriptions, propAdditions) = map.splitByKey(key)
        TlProperty(name, type.toTlType(), propDescriptions, propAdditions)
    }
    return TlMetadata(descriptions, additions, properties)
}

private fun RawTlData.groupLines() =
    list
        .groupBy { it.substringBefore(spaceToken) }
        .mapValues { (_, value) -> value.map { it.substringAfter(spaceToken).capitalize() } }

private fun Map<String, List<String>>.splitByKey(key: String): Pair<List<String>, List<TlAddition>> {
    val lines = this[key] ?: error("No $key in lines")
    val additions = lines.map(::TlAddition)
    val documentations = additions.filterIsInstance<TlAddition.Documentation>()
    return documentations.map(TlAddition.Documentation::message) to additions - documentations
}
