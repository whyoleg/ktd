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

fun TlProperty.parameter(nullable: Boolean, default: Boolean): ParameterSpec =
    ParameterSpec.builder(name.snakeToCamel(), type.className(nullable))
        .apply { if (default) defaultValue(type.default) }
        .build()

fun TlProperty.property(nullable: Boolean): PropertySpec =
    PropertySpec.builder(name.snakeToCamel(), type.className(nullable))
        .initializer(name.snakeToCamel())
        .addAnnotation(serialName(name))
        .apply {
            additions.filterIsInstance<TlAddition.Annotation>()
                .map { ClassName(pcg, it.annotation) }
                .forEach(::addAnnotation)
        }
        .build()

fun tdConstructor(extraNeeded: Boolean, block: FunSpec.Builder.() -> Unit): FunSpec = FunSpec.constructorBuilder()
    .apply(block)
    .apply { if (extraNeeded) addParameter(extraParameter) }
    .build()

fun TypeSpec.Builder.constructor(data: TlData, extraNeeded: Boolean): TypeSpec.Builder = apply {
    primaryConstructor(tdConstructor(extraNeeded) {
        parameters += data.metadata.properties.map {
            it.parameter(
                it.additions.any { it is TlAddition.Nullable } || data is TlFunction,
                data is TlFunction
            )
        }
    })
    propertySpecs += data.metadata.properties.map {
        it.property(it.additions.any { it is TlAddition.Nullable } || data is TlFunction)
    }
}
