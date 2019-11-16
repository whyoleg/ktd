import dev.whyoleg.kamp.*
import kotlinx.atomicfu.plugin.gradle.*

kampJvm {
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.githubApi
            }
        }
    }
}

tasks.register<JavaExec>("generateApi") {
    group = "generation"
    description = "Generate API based on tdlib api scheme"
    classpath = sourceSets["main"].runtimeClasspath
    main = "dev.whyoleg.ktd.generator.ApiGeneratorKt"
    args = listOf(System.getProperty("TD_API_VERSION").toString())
    workingDir = rootDir
}
