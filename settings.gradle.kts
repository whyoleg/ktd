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

inline fun ModuleContext.m(name: String, path: String? = null, block: ModuleContext.() -> Unit = {}) {
    val p = path?.let { "$it/" } ?: ""
    name("${p}ktd-$name", block = block)
}

modules {
    "cli"()

    m("json")
    m("api-core")
    m("client")
    m("tdlib")

    m("api") // latest: 1.6.0

    "clients" {
        m("client-deferred", "clients")
        m("client-rx2", "clients") //experimental
        m("client-rx3", "clients") //experimental
        m("client-reactor", "clients") //experimental
        m("client-reaktive", "clients") //experimental
    }

    "updates" {
        m("updates-flow", "updates") //experimental
    }

}
