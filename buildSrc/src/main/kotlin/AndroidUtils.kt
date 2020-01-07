import com.android.build.gradle.*
import org.gradle.kotlin.dsl.*

fun LibraryExtension.default() {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
    }
    sourceSets {
        val main by getting {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            java.srcDir("src/androidMain/kotlin")
            res.srcDir("src/androidMain/res")
        }
        val androidTest by getting {
            java.srcDir("src/androidTest/kotlin")
            res.srcDir("src/androidTest/res")
        }
    }
}
