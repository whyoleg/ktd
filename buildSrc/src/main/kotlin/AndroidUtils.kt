import com.android.build.gradle.*

fun LibraryExtension.default() {
    defaultPublishConfig = "debug"
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
    }
    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            java.srcDir("src/androidMain/kotlin")
            res.srcDir("src/androidMain/res")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
            res.srcDir("src/androidTest/res")
        }
    }
}
