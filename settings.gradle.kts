import dev.whyoleg.kamp.project.*

buildscript {
    repositories {
        maven("https://dl.bintray.com/whyoleg/kamp")
        maven("https://dl.bintray.com/kotlin/kotlinx")
        mavenCentral()
        google()
        jcenter()
    }
    dependencies {
        classpath("dev.whyoleg.kamp:kamp:0.2.1-pre-4")
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.3.61")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.61")
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.14.1")
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
        classpath("org.jetbrains.kotlinx:kotlinx.benchmark.gradle:0.2.0-dev-7")
    }
}

inline fun ModuleContext.m(name: String, path: String? = null, block: ModuleContext.() -> Unit = {}) {
    val p = path?.let { "$it/" } ?: ""
    name("${p}ktd-$name", block = block)
}

modules {
    "cli"()
    "benchmarks"()
    //    "integration"()
    //    "samples"()

    m("tdlib")
    m("json")
    m("core")
    m("client")

    // latest: 1.6.0
    m("api")
    m("core-api")
    m("bots-api")
    m("test-api")
    m("deprecated-api") //TODO remove in 0.6.1

    "clients" {
        m("client-deferred", "clients")
        m("client-coroutines", "clients")
        //        m("client-rx2", "clients") //experimental
        //        m("client-rx3", "clients") //experimental
        //        m("client-reactor", "clients") //experimental
        //        m("client-reaktive", "clients") //experimental
    }

    "updates" {
        m("updates-flow", "updates") //experimental
    }

}
