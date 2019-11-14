package dev.whyoleg.ktd.generator.builder

fun String.snakeToCamel(): String = split("_").joinToString("") { it.capitalize() }.decapitalize()
