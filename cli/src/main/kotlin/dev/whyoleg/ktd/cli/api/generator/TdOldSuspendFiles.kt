package dev.whyoleg.ktd.cli.api.generator

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.tl.*

private val customMapping = mapOf(
    "SetName" to "User",
    "SetBio" to "User",
    "DeleteSavedCredentials" to "Payment",
    "GetPushReceiverId" to "Notification"
)

private val ignoredTypes = setOf(
    "T",
    "Ok",
    "Top",
    "Basic",
    "Chats",
    "Count",
    "Error",
    "Formatted",
    "Found",
    "Http",
    "Imported",
    "Messages",
    "Public",
    "Push",
    "Recovery",
    "Saved",
    "Scope",
    "Seconds",
    "Sessions",
    "Stickers",
    "Temporary",
    "Update",
    "Users",
    "Animations",
    "Backgrounds",
    "Draft",
    "Emojis",
    "Hashtags",
    "Send"
)

private val additionalTypes = setOf("Emoji", "Group", "Hashtag")

private val comporator = Comparator<Pair<String, Int>> { t1, t2 ->
    when (val c1 = t1.second.compareTo(t2.second)) {
        0    -> t2.first.length.compareTo(t1.first.length)
        else -> c1
    }
}

private fun Iterable<String>.findByType(type: String): String? =
    map { it to type.indexOf(it) }
        .filter { it.second != -1 }
        .sortedWith(comporator)
        .firstOrNull()
        ?.first

private fun List<TlData>.types(): List<String> =
    filter { it is TlObject || it is TlSealed || it is TlSealedChild }
        .map { it.type.decapitalize().takeWhile(Char::isLowerCase).capitalize() }
        .distinct()

private fun List<TlData>.groupFunctions(): Map<String, List<TlFunction>> {
    val types = (types() - ignoredTypes + additionalTypes).sorted().toSet()
    return filterIsInstance<TlFunction>()
        .map { it to (it.type.capitalize() to it.returnType.capitalize()) }
        .groupBy { (_, pair) ->
            val (funcType, returnType) = pair
            val type = customMapping[funcType]
                ?: types.findByType(returnType)
                ?: types.findByType(funcType)
                ?: "Util"
            type
        }
        .mapValues { (_, list) -> list.map { it.first } }
}

fun oldSuspendTdApiFunctions(typedScheme: TlTypedScheme) {
    val tdClient = ClassName("dev.whyoleg.ktd", "TelegramClient")

    val groups = typedScheme.data.groupFunctions()
    groups.forEach { (group, functions) ->
        file("Td$group", "$pcg.${group.toLowerCase()}", "migration/v060", "ktd-api-coroutines") {
            addAnnotation(AnnotationSpec.builder(ClassName("kotlin", "Suppress")).addMember("\"DEPRECATION_ERROR\"").build())
            functions.forEach { data ->
                addFunction(FunSpec.builder(group.toLowerCase()).apply {
                    addModifiers(KModifier.SUSPEND)
                    receiver(tdClient)
                    returns(ClassName(pcg, "Td${data.returnType}"))
                    parameters += TlProperty("f", TlRefType(data.type), emptyList(), emptyList()).parameter(false, false)
                    addStatement("return exec(f)")
                    addAnnotation(
                        deprecated(
                            "\"Use plain exec or named functions\"",
                            replaceWith = "exec(f)",
                            error = true
                        )
                    )
                }.build())

                addFunction(FunSpec.builder(data.type.decapitalize()).apply {
                    addModifiers(KModifier.SUSPEND)
                    receiver(tdClient)
                    returns(ClassName(pcg, "Td${data.returnType}"))
                    parameters += data.metadata.properties.sortedBy { TlAddition.BotsOnly in it.additions }.map { it.parameter(true, true) }
                    addStatement("return exec(Td${data.type}(${parameters.joinToString { it.name }}))")
                    addAnnotation(
                        deprecated(
                            "\"Use functions under `suspend` package instead. You need manually remove old import.\"",
                            replaceWith = "${data.type.decapitalize()}(${parameters.joinToString { it.name }})",
                            imports = listOf("$pcg.suspend.${data.type.decapitalize()}"),
                            error = true
                        )
                    )
                }.build())

                addImport(pcg, "Td${data.type}")
            }
        }
    }

}
