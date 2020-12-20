pluginManagement {
    repositories {
        maven("https://dl.bintray.com/kotlin/kotlinx")
        maven("https://dl.bintray.com/whyoleg/kamp")
        mavenCentral()
        google()
        jcenter()
        gradlePluginPortal()
    }

    fun v(name: String): String = extra["kamp.version.$name"] as String

    plugins {
        val kotlinVersion = v("kotlin")

        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion

        kotlin("plugin.allopen") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion

        id("kotlinx.benchmark") version v("kotlinx.benchmark")

        id("com.github.ben-manes.versions") version v("updates")
        id("com.github.johnrengelman.shadow") version v("shadow")
    }

}

buildscript {
    repositories {
        maven("https://dl.bintray.com/whyoleg/kamp")
        mavenCentral()
        google()
        jcenter()
    }

    fun v(name: String): String = extra["kamp.version.$name"] as String

    dependencies {
        classpath("dev.whyoleg.kamp:kamp-settings:${v("kamp")}")

        classpath("com.android.tools.build:gradle:${v("android.plugin")}")

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${v("kotlin")}") //needed by atomicfu
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:${v("kotlinx.atomicfu")}")
    }

}

kamp {
    versions()
    modules {
        val ktd = "ktd".prefixedModule
        val api = "ktd-api".prefixedModule
        val apiTypes = listOf("core")//, "user", "bots", "test")

        module("cli")
//        module("benchmarks")
//        module("integration")
//        module("samples")

        ktd("client")
//        ktd("client-core")
        ktd("client-coroutines")

        ktd("tdlib")
        ktd("test")

//        ktd("migration") // need for migration from 0.5.0 to 0.6.0, will be removed in 0.6.1

//        folder("ktd-api-generated", "GeneratedApi") {
//            apiTypes.forEach {
//                api(it)
//                api("$it-coroutines")
//            }
//        }
    }
}
