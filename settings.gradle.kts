import dev.whyoleg.kamp.project.*

buildscript {
    repositories {
        maven("https://dl.bintray.com/whyoleg/kamp")
        maven("https://dl.bintray.com/kotlin/kotlinx")
        mavenCentral()
        google()
        jcenter()
        gradlePluginPortal()
    }
    dependencies {
        val kotlinVersion = "1.3.72"
        classpath("dev.whyoleg.kamp:kamp:0.2.1-pre-5")
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.14.3")
        classpath("com.github.jengelman.gradle.plugins:shadow:5.2.0")
        classpath("org.jetbrains.kotlinx:kotlinx.benchmark.gradle:0.2.0-dev-7")
        classpath("com.github.ben-manes:gradle-versions-plugin:0.27.0")
    }
}

inline fun ModuleBuilder.ktd(name: String, path: String? = null, ignore: Boolean = false, block: ModuleBuilder.() -> Unit = {}) {
    name(path = "${path?.let { "$it/" } ?: ""}ktd-${name.toDashLowerCase()}", ignore = ignore, block = block)
}

modules {
    "cli"()
    "benchmarks"()
    "integration"()
    //    "samples"()

    ktd("tdlib")
    ktd("json")
    ktd("core")
    ktd("test")
    ktd("client") {
        ktd("clientCore")
        ktd("clientSuspend")
        ktd("clientCoroutines")
    }
    ktd("api") { // latest: 1.6.0
        listOf("Core", "User", "Bots", "Test").forEach {
            ktd("api$it")
            ktd("api${it}Suspend")
        }
    }
    ktd("updates") {
        ktd("updatesFlow") //experimental
    }
    "migration" {
        "v060" { //TODO remove in 0.6.1
            "clientRaw"("ktd-client-raw")
            "apiRaw"("ktd-api-raw")
            "apiCoroutines"("ktd-api-coroutines")
        }
    }
}
