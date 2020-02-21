package dev.whyoleg.ktd.cli.api.generator

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.*
import dev.whyoleg.ktd.cli.tl.*

val extraProperty =
    PropertySpec.builder("extra", ClassName(pcg, "TdExtra"))
        .initializer("extra")
        .addModifiers(KModifier.OVERRIDE)
        .addAnnotation(serialName("@extra"))
        .build()
val extraParameter =
    ParameterSpec.builder("extra", ClassName(pcg, "TdExtra"))
        .defaultValue("TdExtra.EMPTY")
        .build()

fun TlProperty.parameter(nullable: Boolean, default: Boolean, old: Boolean = false): ParameterSpec =
    ParameterSpec.builder(name.snakeToCamel(), type.className(nullable, old))
        .apply {
            if (default) {
                if (!old) defaultValue(type.default)
                else {
                    if (type is TlArrayType) defaultValue(type.type.oldArrayDefault)
                    else defaultValue(type.default)
                }
            }
        }
        .build()

fun TlProperty.property(nullable: Boolean, old: Boolean = false): PropertySpec =
    PropertySpec.builder(name.snakeToCamel(), type.className(nullable, old))
        .initializer(name.snakeToCamel())
        .apply { if (!old) addAnnotation(serialName(name)) }
        .apply { if (TlAddition.BotsOnly in additions) addAnnotation(ClassName(pcg, "TdBotsOnly")) }
        .build()

fun TypeSpec.Builder.constructor(data: TlData, extraNeeded: Boolean, old: Boolean = false): TypeSpec.Builder = apply {
    val sortedProperties = data.metadata.properties.sortedBy { TlAddition.BotsOnly in it.additions }
    primaryConstructor(FunSpec.constructorBuilder().apply {
        parameters += sortedProperties.map {
            it.parameter(it.additions.any { it is TlAddition.Nullable } || data is TlFunction, data is TlFunction, old)
        }
        if (extraNeeded) addParameter(extraParameter)
    }.build())
    propertySpecs += sortedProperties.map {
        it.property(it.additions.any { it is TlAddition.Nullable } || data is TlFunction, old)
    }
    if (extraNeeded) addProperty(extraProperty)
}
