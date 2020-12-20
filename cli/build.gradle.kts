import dev.whyoleg.kamp.feature.kotlin.KotlinOptIn
import dev.whyoleg.kamp.feature.kotlinx.KotlinxOptIn
import dev.whyoleg.kamp.feature.ktor.KtorOptIn

plugins {
    ids(Plugins.cli)
}

kotlin {
    target.sourceSetMain.languageSettings.apply {
        default()

        useExperimentalAnnotation(KotlinOptIn.experimentalTime)
        useExperimentalAnnotation(KotlinxOptIn.experimentalCoroutinesApi)
        useExperimentalAnnotation(KotlinxOptIn.experimentalCli)
        useExperimentalAnnotation(KotlinxOptIn.implicitReflectionSerializer)
        useExperimentalAnnotation(KtorOptIn.ktorExperimentalAPI)
    }
//    languageSettings {
//        default()
//
//        useExperimentalAnnotation(KotlinOptIn.experimentalTime)
//        useExperimentalAnnotation(KotlinxOptIn.experimentalCoroutinesApi)
//        useExperimentalAnnotation(KotlinxOptIn.experimentalCli)
//        useExperimentalAnnotation(KotlinxOptIn.implicitReflectionSerializer)
//        useExperimentalAnnotation(KtorOptIn.ktorExperimentalAPI)
//    }
    kotlinOptions {
//        allWarningsAsErrors = true
        jvmTarget = "1.6"
    }
    target.kampSourceSetMain.dependencies {
        implementation(Dependencies.kotlin.stdlib)
        implementation(Dependencies.kotlinx.cli)
        implementation(Dependencies.kotlinx.serialization)
        implementation(Dependencies.kotlinx.serialization.configParser)
        implementation(Dependencies.ktor.client.engines.cio)
        implementation(Dependencies.githubApi)
        implementation(Dependencies.kotlinShell)
        implementation(Dependencies.kotlinPoet)
    }
}

shadow {
    archiveClassifier.set("")
    archiveVersion.set("")
}
