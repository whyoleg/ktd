package dev.whyoleg.ktd.generator

import java.io.*
import java.util.zip.*

data class Documentation(
    val main: String,
    val byParameters: List<Pair<String, String>>
)

data class Definition(
    val name: String,
    val returnType: String,
    val documentation: Documentation,
    val parameters: List<Pair<String, String>>,
    val crc: Int
)

const val pack = "dev.whyoleg.ktd"
const val dir = "library/src/main/kotlin/dev/whyoleg/ktd/api"
val customKinds = listOf("Photo", "Notification", "Poll", "Animation")

fun header(subPack: String): String =
    """
        @file:Suppress("unused")

        package $pack.api.$subPack

        import $pack.*
        import $pack.api.TdApi.*
    """.trimIndent()

val apiHeader = """
    package $pack.api

    typealias TelegramObject = TdApi.Object
    typealias TelegramFunction = TdApi.Function

    class TdApi {
        abstract class Object {
            external override fun toString(): String
            abstract val constructor: Int
        }
    
        abstract class Function : Object() {
            external override fun toString(): String
        }
        
""".trimIndent()

fun decodeType(type: String): String = when (val t = type.capitalize()) {
    "Int32"                          -> "Int"
    "Int53", "Int64"                 -> "Long"
    "Bool"                           -> "Boolean"
    "Bytes"                          -> "ByteArray"
    "Vector<int32>"                  -> "IntArray"
    "Vector<int53>", "Vector<int64>" -> "LongArray"
    "Vector<bool>"                   -> "BooleanArray"
    else                             -> when {
        t.startsWith("Vector") -> "Array<${decodeType(t.drop(7).dropLast(1))}>"
        else                   -> t
    }
}

fun List<String>.groupBlocks(): List<List<String>> {
    val mutableList = mutableListOf<List<String>>()
    val list = mutableListOf<String>()
    forEach {
        if (it.startsWith("//@description ") && list.isNotEmpty()) {
            mutableList.add(list.toList())
            list.clear()
        }
        list += it
    }
    if (list.isNotEmpty()) mutableList.add(list)
    return mutableList
}

fun List<List<String>>.parseDefinitions(): List<Definition> = map { list ->
    val documentation = list.dropLast(1)
    val func = list.last().dropLast(1)
    val funcDefinition = func.split(" ")
    val funcName = funcDefinition.first().capitalize()
    val returnType = funcDefinition.last()
    val parameters = funcDefinition.drop(1).dropLast(2).map { it.split(":") }.map { (name, type) ->
        val fName = name.split("_").joinToString("") { it.capitalize() }.decapitalize()
        val fType = decodeType(type)
        fName to fType
    }

    val doc = documentation
        .joinToString("")
        .replace("//-", "\n")
        .replace("//@description ", "")
        .replace("//", "")
        .replace(" @", "@")
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

    val crc = CRC32().apply { update(func.toByteArray()) }.value.toInt()

    Definition(
        name = funcName,
        returnType = returnType,
        documentation = documentation2,
        parameters = parameters,
        crc = crc
    )
}

val Definition.valsString
    get() = if (parameters.isNotEmpty())
        parameters.joinToString(",\n    ", "(\n    ", "\n)") { (name, type) -> "val $name: $type" }
    else ""

fun List<Definition>.generateClasses(superClassChooser: (Definition) -> String): List<String> = map {
    val docMain = it.documentation.main.replace("\n", "\n * ")
    val docParams =
        if (it.documentation.byParameters.isNotEmpty())
            it.documentation.byParameters.joinToString("\n *", "\n *\n *") { (name, text) -> " @$name - $text" }
        else ""

    val fullDoc = "/**\n * $docMain$docParams\n */"

    "$fullDoc\nclass ${it.name}${it.valsString} : ${superClassChooser(it)}() {\n    override val constructor: Int get() = ${it.crc}\n}\n"
}

fun main() {

    val lines = File("td/td/generate/scheme/td_api.tl").readLines().filter(String::isNotEmpty)
    val rawFunctions = lines.dropWhile { it != "---functions---" }.drop(1)

    val (rawClasses, rawObjects) =
        lines
            .dropWhile { !it.startsWith("vector") }.drop(1)
            .takeWhile { it != "---functions---" }
            .partition { it.startsWith("//@class") }

    val classes = rawClasses.map { it.substringAfter("//@class ") }
    val classNames = classes.map { it.substringBefore(" ") }

    val generatedAbstracts = classes.map {
        val name = it.substringBefore(" ")
        val documentation = it.substringAfter(" @description ")
        it.substringBefore(" ") to "/**\n * $documentation\n */\nabstract class $name : Object()"
    }.toMutableList()

    val objectsDefinitions = rawObjects.groupBlocks().parseDefinitions()
    val generatedObjects = objectsDefinitions.generateClasses { def -> classNames.find { it == def.returnType } ?: "Object" }
    val zippedObjects = objectsDefinitions zip generatedObjects

    val functionDefinitions = rawFunctions.groupBlocks().parseDefinitions()
    val generatedFunctions = functionDefinitions.generateClasses { "Function" }

    val objects = zippedObjects.joinToString("\n") { (def, classText) ->
        val text = generatedAbstracts.find { it.first == def.returnType }?.second
        if (text != null) {
            generatedAbstracts.removeIf { it.first == def.returnType }
            "$text\n\n$classText"
        } else classText
    }
    val functions = generatedFunctions.joinToString("\n")
    val result = "$objects\n$functions".split("\n").joinToString("\n    ", "    ").replace("    \n", "\n")
    val apiText = "$apiHeader\n$result\n}"

    File(dir).mkdirs()
    File("$dir/TdApi.kt").writeText(apiText)

    val returnTypes = functionDefinitions.map(Definition::returnType).toSet()
    val functionKinds = returnTypes.map { it to it.decapitalize().takeWhile(Char::isLowerCase).capitalize() }.toMap()
    val kinds = functionKinds.values.toMutableList() + customKinds - "Ok" - "T"
    val groupedFunctions = functionDefinitions.groupBy { (name, returnType) ->
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
        val generatedFunctions = list.map { (name, returnType, documentation, parameters) ->
            val docMain = documentation.main.replace("\n", "\n * ")
            val docParams =
                if (documentation.byParameters.isNotEmpty())
                    documentation.byParameters.joinToString("\n *", "\n *\n *") { (name, text) -> " @$name - $text" }
                else ""

            val shortDoc = "/**\n * $docMain\n */"
            val fullDoc = "/**\n * $docMain$docParams\n */"
            val params = if (parameters.isNotEmpty()) parameters.joinToString(",\n    ", "\n    ", "\n") { (n, t) -> "$n: $t" } else ""
            val paramsCall = if (parameters.isNotEmpty()) parameters.joinToString(",\n        ", "\n        ", "\n    ") { it.first } else ""
            val raw = "$shortDoc\nsuspend fun TelegramClient.$kind(\n    f: $name\n): $returnType = execRaw(f) as $returnType\n"
            val paramed =
                "$fullDoc\nsuspend fun TelegramClient.${name.decapitalize()}($params): $returnType = $kind(\n    $name($paramsCall)\n)\n"
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
