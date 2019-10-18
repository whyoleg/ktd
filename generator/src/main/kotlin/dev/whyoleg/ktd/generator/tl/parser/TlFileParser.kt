package dev.whyoleg.ktd.generator.tl.parser

import dev.whyoleg.ktd.generator.tl.*
import java.util.zip.*

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

private fun String.crc(): Int = CRC32().apply { update(toByteArray()) }.value.toInt()

private fun RawTlData.toTlData(): TlData = when (type) {
    RawTlDataType.Object   -> when (expression.contains(spaceToken)) {
        true  -> toObject()
        false -> toAbstract()
    }
    RawTlDataType.Function -> toFunction()
}

private fun RawTlData.toAbstract(): TlAbstract {
    return TlAbstract(expression, list.map { it.substringAfter(descriptionToken).trim() })
}

private fun RawTlData.toObject(): TlObject {
    val type = expression.substringBefore(spaceToken).trim()
    val expressionParentType = expression.substringAfter(equalToken).trim()
    val parentType = if (expressionParentType == type.capitalize()) "Object" else expressionParentType
    val metadata = extractMetadata()
    return TlObject(type, parentType, metadata, expression.crc())
}

private fun RawTlData.toFunction(): TlFunction {
    val type = expression.substringBefore(spaceToken).trim()
    val returnType = expression.substringAfter(equalToken).trim()
    val metadata = extractMetadata()
    return TlFunction(type, returnType, metadata, expression.crc())
}

private fun RawTlData.extractMetadata(): TlMetadata {
    val map =
        list
            .groupBy { it.substringBefore(spaceToken) }
            .mapValues { (_, value) -> value.map { it.substringAfter(spaceToken) } }

    val descriptions = map[descriptionToken] ?: error("No description")
    val additions = map[descriptionToken + questionToken] ?: emptyList()
    val propertiesString = expression.substringAfter(spaceToken).substringBefore(equalToken).trim()
    val properties = if (propertiesString.isBlank()) emptyList()
    else propertiesString.split(spaceToken).map { propertyDefinition ->
        val (name, type) = propertyDefinition.split(":")
        val key = if (name == descriptionToken) descriptionParamToken else name
        val listData = map[key] ?: error("No description")
        val (propAdditions, propDescriptions) = listData.partition { it.startsWith(questionToken) }
        TlProperty(name, type.toTlType(), propDescriptions, propAdditions.map(String::toTlAddition))
    }
    return TlMetadata(descriptions, additions.map(String::toTlAddition), properties)
}

private fun String.toTlAddition(): TlAddition = this
