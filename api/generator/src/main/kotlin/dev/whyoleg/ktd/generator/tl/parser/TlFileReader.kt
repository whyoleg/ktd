package dev.whyoleg.ktd.generator.tl.parser

import dev.whyoleg.ktd.generator.tl.*
import java.io.*

internal fun File.readTlScheme(): List<String> = steps.fold(readLines()) { list, step -> step(list) }

private typealias ParseStep = List<String>.() -> List<String>

private val dropStart: ParseStep = {
    filter(String::isNotBlank).dropWhile { !it.startsWith(doubleSlashToken) }
}

private val splitClasses: ParseStep = {
    flatMap { line ->
        if (line.startsWith(doubleSlashToken + classAddressToken)) {
            val name = line.substringAfter(doubleSlashToken + classAddressToken).substringBefore(
                descriptionAddressToken
            ).trim()
            val description = line.substringAfter(name).trim()
            listOf(doubleSlashToken + description, name)
        } else listOf(line)
    }
}

private val removeDashes: ParseStep = {
    fold(mutableListOf()) { acc, string ->
        if (string.startsWith(slashDashToken)) {
            val last = acc.last().trim()
            val text = string.substringAfter(slashDashToken).trim()
            val new = last + spaceToken + text
            acc[acc.lastIndex] = new
        } else {
            acc += string
        }
        acc
    }
}

private val splitParameters: ParseStep = {
    flatMap { line ->
        val splitted = line.split(spaceToken + addressToken)
        val first = splitted.first().trim()
        val other = splitted.drop(1)
        listOf(first) + other.map { doubleSlashToken + addressToken + it.trim() }
    }
}

private val splitAdditions: ParseStep = {
    flatMap { line ->
        val splitted = line.split(";").filter(String::isNotBlank)
        val first = splitted.first().trim()
        val prefix = first.substringBefore(spaceToken)
        val other = splitted.drop(1)
        val otherPrefixed = other.map { "$prefix$questionToken$spaceToken${it.capitalize().trim()}" }
        listOf(first) + otherPrefixed
    }
}

private val splitSentences: ParseStep = {
    flatMap { line ->
        val splitted = line.split(". ")
        val first = splitted.first()
        val prefix = first.substringBefore(spaceToken)
        val other = splitted.drop(1)
        val otherPrefixed = other.map { "$prefix$spaceToken${it.trim()}" }
        listOf(first) + otherPrefixed
    }
}

private val removeSlashes: ParseStep = {
    map { it.substringAfter(doubleSlashToken) }
}

private val steps: List<ParseStep> = listOf(
    dropStart,
    splitClasses,
    removeDashes,
    splitParameters,
    splitAdditions,
    splitSentences,
    removeSlashes
)
