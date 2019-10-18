package dev.whyoleg.ktd.generator.builder

import dev.whyoleg.ktd.generator.tl.*

fun StringBuilder.write(data: TlData) {
    val declaration = when (data) {
        is TlAbstract -> "abstract class "
        is TlClass    -> "class "
    }
    val propertiesDescriptions =
        if (data.metadata.properties.isEmpty()) emptyList() else listOf("") + data.metadata.properties.flatMap(TlProperty::descriptionLines)
    buildClassDeclaration(
        clazz = declaration + data.type.capitalize(),
        extendType = data.parentType.capitalize(),
        description = data.metadata.descriptions + data.metadata.additions + propertiesDescriptions,
        properties = data.metadata.properties.map(TlProperty::constructorParameter)
    )
    if (data is TlClass) buildConstructorField(data.crc)
    else append("\n")
}

fun TlProperty.constructorParameter(): String {
    val propName = name.snakeToCamel()
    val nullable = if (type.default == "null") "?" else ""
    return "val $propName: ${type.kotlinType}$nullable = ${type.default}"
}

fun TlProperty.descriptionLines(): List<String> {
    val link = "$addressToken${name.snakeToCamel()}$spaceToken$dashToken$spaceToken"
    val spaces = (1..link.length).joinToString("") { " " }
    return listOf(link + descriptions.first()) + descriptions.drop(1).map { "$spaces$it" } + additions.map { "$spaces$it" }
}
