package dev.whyoleg.ktd.cli.api.generator

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.tl.*
import dev.whyoleg.ktd.cli.tl.TlKind as TlKind1

fun suspendTdApiFunctions(typedScheme: TlTypedScheme, kind: TlKind1) {
    val kindName = kind.name.toLowerCase()
    val moduleName = "ktd-api-$kindName-suspend"

    val tdClient = ClassName("dev.whyoleg.ktd.client", "SuspendTdClient")

    typedScheme.functions.forEach { data ->
        file("Td${data.type}", "$pcg.suspend", "api-suspend", moduleName) {
            addFunction(FunSpec.builder(data.type.decapitalize()).apply {
                addModifiers(KModifier.SUSPEND)
                receiver(tdClient)
                returns(ClassName(pcg, "Td${data.returnType}"))
                data.kdoc(true).forEach(::addKdoc)
                parameters += data.metadata.properties.sortedBy { TlAddition.BotsOnly in it.additions }.map { it.parameter(true, true) }
                addParameter(extraParameter)
                addStatement("return exec(Td${data.type}(${parameters.map { it.name }.joinToString()}))")
            }.build())
            addImport(pcg, "Td${data.type}")
        }
    }
}
