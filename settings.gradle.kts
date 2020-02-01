import dev.whyoleg.kamp.project.*

buildscript {
    repositories {
        maven("https://dl.bintray.com/whyoleg/kamp")
        mavenCentral()
        google()
        jcenter()
    }
    dependencies {
        classpath("dev.whyoleg.kamp:kamp:0.2.1-pre-4")
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.61")
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.14.1")
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
    }
}

val tdOnlyVersion = startParameter.projectProperties["tdOnlyVersion"]

val tdVersions = tdOnlyVersion?.let(::listOf) ?: listOf(
    "1.5.0",
    "1.5.1",
    "1.5.2",
    "1.5.3",
    "1.5.4"
)

inline fun ModuleContext.m(name: String, block: ModuleContext.() -> Unit = {}) = name("ktd-$name", block = block)

modules {
    m("json")
    m("api")
    m("api-client")
    m("client")
    m("client-api")
}
