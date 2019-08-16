package dev.whyoleg.ktd.generator

import java.io.*

data class Documentation(
    val main: String,
    val byParameters: List<Pair<String, String>>
)

data class Function(
    val name: String,
    val returnType: String,
    val documentation: Documentation,
    val parameters: List<Pair<String, String>>
)

const val pack = "dev.whyoleg.ktd"
fun header(subPack: String): String =
    """
        @file:Suppress("unused")

        package $pack.api.$subPack

        import $pack.*
        import $pack.api.TdApi.*
    """.trimIndent()

fun decodeType(type: String): String = when (val t = type.capitalize()) {
    "Int32" -> "Int"
    "Int53", "Int64" -> "Long"
    "Bool"  -> "Boolean"
    "Bytes" -> "ByteArray"
    else    -> when {
        t.startsWith("Vector") -> "List<${decodeType(t.drop(7).dropLast(1))}>"
        else                   -> t
    }
}

fun main() {
    val customKinds = listOf("Photo", "Notification", "Poll", "Animation")


    val dir = "library/src/main/kotlin/dev/whyoleg/ktd/api"
    val lines = File("td/td/generate/scheme/td_api.tl").readLines().asSequence()
    val rawFunctions = lines.dropWhile { it != "---functions---" }.drop(1).filter(String::isNotEmpty)

    val groupedRawFunctions = sequence<List<String>> {
        val list = mutableListOf<String>()
        rawFunctions.forEach {
            if (it.startsWith("//@description ") && list.isNotEmpty()) {
                yield(list.toList())
                list.clear()
            }
            list += it
        }
    }

    val functions = groupedRawFunctions.map { list ->
        val documentation = list.dropLast(1)
        val func = list.last()
        val funcDefinition = func.dropLast(1).split(" ")
        val funcName = funcDefinition.first().capitalize()
        val returnType = funcDefinition.last()
        val parameters = funcDefinition.drop(1).dropLast(2).map { it.split(":") }.map { (name, type) ->
            val fName = name.split("_").joinToString("") { it.capitalize() }.decapitalize()
            val fType = decodeType(type)
            fName to fType
        }

        val doc = documentation
            .joinToString(" ")
            .replace("//-", "\n")
            .replace("//@description ", "")
            .replace("//", "")
            .replace("@", "\n@")

        val documentation2 = if (doc.contains("\n@")) {
            val byParameters =
                doc.substringAfter("\n@")
                    .replace("@", "")
                    .split("\n")
                    .map {
                        val pName = it.substringBefore(" ")
                        val fpName = pName.split("_").joinToString("") { it.capitalize() }.decapitalize()
                        pName to (fpName to it.substringAfter(" ").replace(pName, fpName))
                    }
            val formated = byParameters.fold(doc.substringBefore("\n@")) { string, v ->
                string.replace(v.first, v.second.first)
            }
            Documentation(formated, byParameters.map { it.second })
        } else Documentation(doc, emptyList())
        println(documentation2)

        Function(
            name = funcName,
            returnType = returnType,
            documentation = documentation2,
            parameters = parameters
        )
    }

    val returnTypes = functions.map(Function::returnType).toSet()
    val functionKinds = returnTypes.map { it to it.decapitalize().takeWhile(Char::isLowerCase).capitalize() }.toMap()
    val kinds = functionKinds.values.toMutableList() + customKinds - "Ok" - "T"
    val groupedFunctions = functions.groupBy { (name, returnType) ->
        when (returnType) {
            "Ok" -> kinds.map { it to name.indexOf(it) }.filter { it.second != -1 }.sortedWith(Comparator { t1, t2 ->
                when (val c1 = t1.second.compareTo(t2.second)) {
                    0    -> t2.first.length.compareTo(t1.first.length)
                    else -> c1
                }
            }).firstOrNull()?.first ?: "util"
            else -> functionKinds[returnType]!!
        }.decapitalize()
    }

    groupedFunctions.forEach { (kind, list) ->
        println(kind)

        val generatedFunctions = list.map { (name, returnType, documentation, parameters) ->
            val docMain = documentation.main.replace("\n", "\n * ")
            val docParams =
                if (documentation.byParameters.isNotEmpty())
                    documentation.byParameters.joinToString("\n*", "\n *\n *") { (name, text) -> " @$name - $text" }
                else ""

            val shortDoc = "/**\n * $docMain\n */"
            val fullDoc = "/**\n * $docMain$docParams\n */"
            val params = if (parameters.isNotEmpty()) parameters.joinToString(",\n\t", "\n\t", "\n") { (n, t) -> "$n: $t" } else ""
            val paramsCall = if (parameters.isNotEmpty()) parameters.joinToString(",\n\t\t", "\n\t\t", "\n\t") { it.first } else ""
            val raw = "$shortDoc\nsuspend fun TelegramClient.$kind(\n\tf: $name\n): $returnType = execRaw(f) as $returnType\n"
            val paramed =
                "$fullDoc\nsuspend fun TelegramClient.${name.decapitalize()}($params): $returnType = $kind(\n\t$name($paramsCall)\n)\n"
            raw to paramed
        }
        File("$dir/$kind").mkdirs()

        val shortFunctions = generatedFunctions.map { it.first }
        val shortText = "${header(kind)}\n\n${shortFunctions.joinToString("\n")}"
        File("$dir/$kind/Functions.kt").writeText(shortText)

        val longFunctions = generatedFunctions.map { it.second }
        val longText = "${header(kind)}\n\n${longFunctions.joinToString("\n")}"

        File("$dir/$kind/ParameterizedCalls.kt").writeText(longText)
    }

}
