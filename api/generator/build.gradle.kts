import kotlinx.atomicfu.plugin.gradle.*

repositories {
    //TODO needed by kotlin shell
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
}

configure {
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
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
    args = listOf(properties["GITHUB_REF"].toString(), properties["ARCH"].toString())
    workingDir = rootDir
}

tasks.register<JavaExec>("generateApi") {
    group = "generation"
    description = "Generate API based on tdlib api scheme"
    classpath = sourceSets["main"].runtimeClasspath
    main = "dev.whyoleg.ktd.generator.ApiGeneratorKt"
    args = listOf(System.getProperty("TD_API_VERSION") ?: "")
    workingDir = rootDir
}
