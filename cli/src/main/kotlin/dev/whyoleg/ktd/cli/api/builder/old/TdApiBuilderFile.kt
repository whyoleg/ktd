package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.tl.*

fun builderFile(meta: TlSchemeMetadata) {
    val (list, responses, requests, sealedResponses) = meta
    val requestsBlock = CodeBlock.builder().beginControlFlow("polymorphic<TdApiRequest>")

    val responseBlock = CodeBlock.builder().beginControlFlow("polymorphic<TdApiResponse>")

    fun responseBlock(name: String) =
        CodeBlock.builder()
            .beginControlFlow("polymorphic(TdApiResponse::class, ${if (name == "Update") "TdApi.Update" else "Td$name"}::class)")

    val allResponseBlock = CodeBlock.builder()

    list.forEach { data ->
        if (data.type in existed) return@forEach
        when (val type = data.type(responses, requests)) {
            TdType.Request, TdType.SyncRequest -> requestsBlock.addStatement("addSubclass(Td${data.type}.serializer())")
            TdType.Response, TdType.Update     -> when {
                data !is TlAbstract && data.parentType == null -> responseBlock.addStatement("addSubclass(Td${data.type}.serializer())")
                data is TlAbstract                             -> allResponseBlock.add(
                    responseBlock(data.type).apply {
                        sealedResponses.getValue(data.type).forEach { addStatement("addSubclass(Td${it.type}.serializer())") }
                    }.endControlFlow().build()
                )
            }
        }
    }
    file("TdApiBuilder") {
        addProperty(
            PropertySpec.builder(
                    "apiBuilder",
                    LambdaTypeName.get(
                        receiver = ClassName("kotlinx.serialization.modules", "SerializersModuleBuilder"),
                        returnType = ClassName("kotlin", "Unit")
                    )
                )
                .addModifiers(KModifier.INTERNAL)
                .initializer(
                    CodeBlock.builder()
                        .beginControlFlow("{")
                        .add(requestsBlock.endControlFlow().build())
                        .add(responseBlock.endControlFlow().build())
                        .add(allResponseBlock.build())
                        .endControlFlow()
                        .build()
                )
                .build()
        )
    }
}
