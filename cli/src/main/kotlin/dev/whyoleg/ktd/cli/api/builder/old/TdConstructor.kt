package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.builder.*
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
        .apply { if (default) defaultValue(type.default) }
        .build()

fun TlProperty.property(nullable: Boolean, old: Boolean = false): PropertySpec =
    PropertySpec.builder(name.snakeToCamel(), type.className(nullable, old))
        .initializer(name.snakeToCamel())
        .addAnnotation(serialName(name))
        .apply { if (TlAddition.BotsOnly in additions) addAnnotation(ClassName(pcg, "TdBotsOnly")) }
        .build()

fun tdConstructor(extraNeeded: Boolean, block: FunSpec.Builder.() -> Unit): FunSpec = FunSpec.constructorBuilder()
    .apply(block)
    .apply { if (extraNeeded) addParameter(extraParameter) }
    .build()

fun TypeSpec.Builder.constructor(data: TlData, extraNeeded: Boolean, old: Boolean = false): TypeSpec.Builder = apply {
    val sortedProperties = data.metadata.properties.sortedBy { TlAddition.BotsOnly in it.additions }
    primaryConstructor(tdConstructor(extraNeeded) {
        parameters += sortedProperties.map {
            it.parameter(it.additions.any { it is TlAddition.Nullable } || data is TlFunction, data is TlFunction, old)
        }
    })
    propertySpecs += sortedProperties.map {
        it.property(it.additions.any { it is TlAddition.Nullable } || data is TlFunction, old)
    }
    if (extraNeeded) addProperty(extraProperty)
}
