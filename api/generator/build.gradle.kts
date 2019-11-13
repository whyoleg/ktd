import kotlinx.atomicfu.plugin.gradle.*

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
}

configure {
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.coroutines.core
                +Dependencies.githubApi
                +Dependencies.kotlinShell
            }
        }
    }
}

tasks.register<JavaExec>("generateJni") {
    group = "generation"
    description = "Generate tdlib with JNI"
    classpath = sourceSets["main"].runtimeClasspath
    main = "dev.whyoleg.ktd.generator.JniGeneratorKt"
    args = listOf(properties["TD_API_VERSION"].toString())
    workingDir = rootDir
}

tasks.register<JavaExec>("generateApi") {
    group = "generation"
    description = "Generate API based on tdlib api scheme"
    classpath = sourceSets["main"].runtimeClasspath
    main = "dev.whyoleg.ktd.generator.ApiGeneratorKt"
    args = listOf(properties["TD_API_VERSION"].toString(), "g", "l")
    workingDir = rootDir
}
