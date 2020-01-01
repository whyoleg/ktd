package dev.whyoleg.ktd.cli.api

import java.io.*

typealias Entity = Pair<String, String>

fun writeEntitiesLocally(entities: List<Entity>) {
    entities.forEach { (path, content) ->
        println("Create file: $path")
        with(File(path)) {
            parentFile.mkdirs()
            writeText(content)
        }
    }
}
