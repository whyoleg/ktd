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
        val kotlinVersion = "1.3.70"
        classpath("dev.whyoleg.kamp:kamp:0.2.1-pre-4")
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.14.2")
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
        classpath("org.jetbrains.kotlinx:kotlinx.benchmark.gradle:0.2.0-dev-7")
    }
}

inline fun ModuleContext.m(name: String, path: String? = null, ignore: Boolean = false, block: ModuleContext.() -> Unit = {}) {
    val p = path?.let { "$it/" } ?: ""
    name("${p}ktd-$name", ignore, block)
}

fun ModuleContext.mf(folder: String): (modules: List<String>) -> Unit = { modules ->
    folder {
        modules.forEach {
            m(it, folder)
        }
    }
}

modules {
    "cli"()
    "benchmarks"()
    //    "samples"()

    m("tdlib")
    m("json")
    m("core")
    m("client")

    "api-integration"()
    // latest: 1.6.0
    mf("api")(
        listOf(
            "api-core",
            "api-user",
            "api-bots",
            "api-test"
        )
    )
    mf("api-suspend")(
        listOf(
            "api-core-suspend",
            "api-user-suspend",
            "api-bots-suspend",
            "api-test-suspend"
        )
    )
    mf("clients")(
        listOf(
            "client-suspend",
            "client-coroutines"
        )
    )
    mf("updates")(
        listOf(
            "updates-flow" //experimental
        )
    )

    "migration" {
        "v060" { //TODO remove in 0.6.1
            "ktd-client-raw"()
            "ktd-api-raw"()
            "ktd-api-coroutines"()
        }
    }
}
