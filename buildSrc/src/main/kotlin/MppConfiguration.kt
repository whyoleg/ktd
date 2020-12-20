import com.android.build.gradle.*
import dev.whyoleg.kamp.dependency.*
import dev.whyoleg.kamp.feature.kotlin.*
import org.gradle.api.*
import org.gradle.api.publish.maven.tasks.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*

inline fun Project.configureMultiplatform(crossinline block: KotlinMultiplatformExtension.() -> Unit = {}) {
    kotlinMPP {
        kotlinOptions {
            //                    allWarningsAsErrors = true
            freeCompilerArgs += "-Xopt-in=${KotlinOptIn.requiresOptIn}"
            if (this is KotlinJvmOptions) {
                jvmTarget = "1.6"
            }
        }
        languageSettings { sourceSet ->
            default()
            if (sourceSet.name.contains("test", true)) {
                useExperimentalAnnotation(KotlinOptIn.experimentalTime)
            }
        }
//        sourceSets.all {
//            if (name.contains("main", true)) {
//                project.extra.set("kotlin.mpp.freeCompilerArgsForSourceSet.${name}", "-Xexplicit-api=warning")
//            }
//        }
        dependenciesTest {
            implementation(Dependencies.kotlin.test)
            implementation(Dependencies.kotlin.annotations.junit)
            runtimeOnly(Dependencies.atomicfuMetadata)
        }
        block()
    }
    tasks.withType<AbstractPublishToMaven> { enabled = false }
}

class JsonTargets(
    val jsonMain: KampSourceSet,
    val jsonTest: KampSourceSet,
    val jvmMain: KampSourceSet,
    val jvmTest: KampSourceSet
) {
    inline fun dependenciesMain(crossinline configure: KampDependencyHandler.() -> Unit) {
        jsonMain.dependencies(configure)
        jvmMain.dependencies(configure)
    }

    inline fun dependenciesTest(crossinline configure: KampDependencyHandler.() -> Unit) {
        jsonTest.dependencies(configure)
        jvmTest.dependencies(configure)
    }
}

fun KotlinMultiplatformExtension.defaultTargets() {
    jvm()
    withAndroid()
}

fun KotlinMultiplatformExtension.jsonTargets(block: JsonTargets.() -> Unit) {
    val jvm = jvm()

    val jsonMain by sourceSets.creating
    val jsonTest by sourceSets.creating

    jsonMain.dependsOn(kampCommonMain.sourceSet)
    jsonTest.dependsOn(kampCommonTest.sourceSet)

    jvm.sourceSetMain.dependsOn(jsonMain)
    jvm.sourceSetTest.dependsOn(jsonTest)

    JsonTargets(
        jsonMain = jsonMain.kampCommon,
        jsonTest = jsonTest.kampCommon,
        jvmMain = jvm.kampSourceSetMain,
        jvmTest = jvm.kampSourceSetTest
    ).block()
}

fun KotlinMultiplatformExtension.withAndroid() {
    android().project.extensions.configure<LibraryExtension> {
//    defaultPublishConfig = "debug" //TODO check
        compileSdkVersion(29)
        defaultConfig {
            minSdkVersion(21)
            targetSdkVersion(29)
            versionCode = 1
            testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        }
        sourceSets {
            getByName("main") {
                setRoot("src/androidMain")
                java.srcDir("src/androidMain/kotlin")
            }
            getByName("androidTest") {
                java.srcDir("src/androidTest/kotlin")
            }
        }
        packagingOptions {
            exclude("META-INF/kotlinx-coroutines-core.kotlin_module")
            exclude("META-INF/kotlinx-serialization-runtime.kotlin_module")
        }
    }

    sourceSets {
        getByName("androidMain").dependsOn(getByName("jvmMain"))
        getByName("androidTest").dependsOn(getByName("jvmTest")) //TODO
    }
}
