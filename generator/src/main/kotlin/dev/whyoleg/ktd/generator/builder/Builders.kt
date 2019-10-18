package dev.whyoleg.ktd.generator.builder


fun StringBuilder.buildDescription(lines: List<String>) {
    append("/**\n")
    lines.joinTo(this, "\n * ", " * ", "\n")
    append(" */\n")
}

fun StringBuilder.buildConstructorField(crc: Int) {
    append("{\n")
    append("    override val constructor: Int get() = ").append(crc)
    append("\n}\n")
}

fun StringBuilder.buildParameters(parameters: List<String>) {
    parameters.joinTo(this, ",\n    ", "(\n    ", "\n)")
}

fun StringBuilder.buildClassDeclaration(
    clazz: String,
    extendType: String,
    description: List<String>,
    properties: List<String> = emptyList()
) {
    val extends = ": $extendType() "
    buildDescription(description)
    append(clazz)
    properties.takeIf(List<*>::isNotEmpty)?.let(this::buildParameters)
    append(extends)
}
