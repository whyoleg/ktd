package dev.whyoleg.ktd.cli

import dev.whyoleg.ktd.cli.api.*
import dev.whyoleg.ktd.cli.api.tl.*
import dev.whyoleg.ktd.cli.api.tl.diff.*
import dev.whyoleg.ktd.cli.tdlib.*
import kotlinx.cli.*
import kotlinx.coroutines.*
import java.io.*
import kotlin.time.*

@UseExperimental(ExperimentalCli::class)
fun main1(args: Array<String>) {
    val api = arrayOf("api", "-v", "1.5.4", "-e", "config/api")
    val tdlibAndroid = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "android-armv7", "-e", "config/tdlib")
    val tdlibLinux = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "linux", "-e", "config/tdlib")
    val args = api
    val parser = ArgParser("ktd")
    parser.subcommands(TdlibCommand, ApiCommand)
    parser.parse(args)
}

fun scheme(version: String): TlScheme {
    val scheme = File("$version.tl").readBytes()
//    val scheme = GitHub.connectAnonymously().downloadScheme(version)
    return scheme.parseScheme()
}


data class KeysDiff(val added: Set<String>, val removed: Set<String>, val intersection: Set<String>)

infix fun Map<String, *>.diff(new: Map<String, *>): KeysDiff {
    val oldKeys = this.keys
    val newKeys = new.keys
    val addedKeys = newKeys - oldKeys
    val removedKeys = oldKeys - newKeys
    val intersectionKeys = oldKeys intersect newKeys
    return KeysDiff(addedKeys, removedKeys, intersectionKeys)
}

fun <T : Any> List<T>.takeIfIsNotEmpty(): List<T>? = takeIf(List<T>::isNotEmpty)

inline fun <reified T : Any, D : Any> TlScheme.diff(new: TlScheme, diff: (old: List<T>, new: List<T>) -> D?): D? =
    diff(this.data.filterIsInstance<T>(), new.data.filterIsInstance<T>())

inline fun <T : Any, D : Any> Map<String, T>.diff(new: Map<String, T>, keys: KeysDiff, diff: (old: T, new: T) -> D?): List<D>? =
    keys.intersection.mapNotNull { diff(getValue(it), new.getValue(it)) }.takeIfIsNotEmpty()

inline fun <T : Any, ED : Any, D : Any> List<T>.diff(
    new: List<T>,
    keySelector: (T) -> String,
    elementDiff: (old: T, new: T) -> D?,
    resultDiff: (added: List<T>?, removed: List<T>?, changed: List<D>?) -> ED
): ED? {
    val oldMap = this.associateBy(keySelector)
    val newMap = new.associateBy(keySelector)
    val keys = oldMap diff newMap
    val diff = oldMap.diff(newMap, keys, elementDiff)
    val added = new.filter { keySelector(it) in keys.added }.takeIfIsNotEmpty()
    val removed = this.filter { keySelector(it) in keys.removed }.takeIfIsNotEmpty()
    return if (added == null && removed == null && diff == null) null else resultDiff(added, removed, diff)
}

infix fun <T : Any> List<T>.listDiff(other: List<T>): List<T>? = (this - other).takeIfIsNotEmpty()

infix fun String.typeDiff(new: String): TlTypeDiff? = if (this == new) null else TlTypeDiff(this, new)

inline fun <R : Any, D1, D2> constructorDiff(diff1: D1, diff2: D2, constructor: (D1, D2) -> R): R? =
    if (diff1 == null && diff2 == null) null else constructor(diff1, diff2)

inline fun <R : Any, D1, P1> constructorDiff(diff1: D1, constructor: (P1, D1) -> R, param1: P1): R? =
    if (diff1 == null) null else constructor(param1, diff1)

inline fun <R : Any, D1, D2, P1> constructorDiff(diff1: D1, diff2: D2, constructor: (P1, D1, D2) -> R, param1: P1): R? =
    if (diff1 == null && diff2 == null) null else constructor(param1, diff1, diff2)

inline fun <R : Any, D1, D2, D3> constructorDiff(diff1: D1, diff2: D2, diff3: D3, constructor: (D1, D2, D3) -> R): R? =
    if (diff1 == null && diff2 == null && diff3 == null) null else constructor(diff1, diff2, diff3)


infix fun List<TlAbstract>.diff(new: List<TlAbstract>): TlAbstractListDiff? =
    diff(new, TlAbstract::type, TlAbstract::diff, ::TlAbstractListDiff)

infix fun List<TlObject>.diff(new: List<TlObject>): TlObjectListDiff? =
    diff(new, TlObject::type, TlObject::diff, ::TlObjectListDiff)

infix fun List<TlFunction>.diff(new: List<TlFunction>): TlFunctionListDiff? =
    diff(new, TlFunction::type, TlFunction::diff, ::TlFunctionListDiff)

infix fun List<TlProperty>.diff(new: List<TlProperty>): TlPropertyListDiff? =
    diff(new, TlProperty::name, TlProperty::diff, ::TlPropertyListDiff)


infix fun List<TlAddition>.diff(new: List<TlAddition>): TlAdditionListDiff? =
    constructorDiff(new listDiff this, this listDiff new, ::TlAdditionListDiff)

infix fun TlObject.diff(new: TlObject): TlObjectDiff? =
    constructorDiff(this.parentType typeDiff new.parentType, this.metadata diff new.metadata, ::TlObjectDiff, type)

infix fun TlFunction.diff(new: TlFunction): TlFunctionDiff? =
    constructorDiff(this.returnType typeDiff new.returnType, this.metadata diff new.metadata, ::TlFunctionDiff, type)

infix fun TlAbstract.diff(new: TlAbstract): TlAbstractDiff? =
    constructorDiff(this.metadata diff new.metadata, ::TlAbstractDiff, type)

infix fun TlMetadata.diff(new: TlMetadata): TlMetadataDiff? =
    constructorDiff(this.additions diff new.additions, this.properties diff new.properties, ::TlMetadataDiff)

infix fun TlProperty.diff(new: TlProperty): TlPropertyDiff? =
    constructorDiff(this.type.kotlinType typeDiff new.type.kotlinType, this.additions diff new.additions, ::TlPropertyDiff, name)

infix fun TlScheme.diff(new: TlScheme): TlSchemeDiff? =
    constructorDiff(diff(new, List<TlAbstract>::diff), diff(new, List<TlObject>::diff), diff(new, List<TlFunction>::diff), ::TlSchemeDiff)

fun main(): Unit = runBlocking {
    val oldScheme = scheme("1.5.0")
    val newScheme = scheme("1.5.4")
    val (value, time) = measureTimedValue {
        val diff = oldScheme diff newScheme
        diff?.let {
            buildString { schemeDiff(it) }.arrangeDiff()
        }
    }
    println(time)
    println(value)
}

fun String.arrangeDiff(): String = split("\n").joinToString("\n") {
    val p = it.indexOf("!+")
    val m = it.indexOf("!-")
    when {
        p != -1 -> it.replaceRange(0, p + 2, "+" + " ".repeat(p + 1))
        m != -1 -> it.replaceRange(0, m + 2, "-" + " ".repeat(m + 1))
        else    -> it
    }
}
