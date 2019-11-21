package dev.whyoleg.ktd.generator.api.builder

fun String.snakeToCamel(): String = split("_").joinToString("") { it.capitalize() }.decapitalize()
