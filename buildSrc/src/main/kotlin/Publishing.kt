//import dev.whyoleg.kamp.publication.*
//import dev.whyoleg.kamp.publication.Publication
//import org.gradle.api.*
//import org.gradle.api.publish.*
//import org.gradle.api.publish.maven.*
//import org.gradle.api.publish.maven.tasks.*
//import org.gradle.kotlin.dsl.*
//
//private val publication = Publication(
//    name = "ktd",
//    description = "Kotlin wrapper on TDLib",
//    licenses = listOf(License.apache2),
//    developers = listOf(Developer("whyoleg", "Oleg", "whyoleg@gmail.com")),
//    labels = listOf("Kotlin", "Telegram"),
//    url = "https://github.com/whyoleg/ktd",
//    vcsUrl = "https://github.com/whyoleg/ktd"
//)
//private val stubPublisher = BintrayPublisher("whyoleg", "ktd", "")
//private val ktdPublisher = stubPublisher.copy(name = "ktd")
//private val ktdApiPublisher = stubPublisher.copy(name = "ktd-api")
//private val ktdTdlibPublisher = stubPublisher.copy(name = "ktd-tdlib")
//
//private fun Project.bool(propertyName: String): Boolean =
//    properties[propertyName]?.toString()?.toBoolean() == true
//
//private fun Project.publishing(
//    publisher: BintrayPublisher,
//    publishKey: String,
//    moduleName: String,
//    versionConfiguration: () -> String
//): Unit = afterEvaluate {
//    extensions.configure<PublishingExtension> {
//        repositories(publisher.provider())
//        publications.all {
//            this as MavenPublication
//            pom(publication)
//            val name = when (val target = artifactId.substringAfterLast("-")) {
//                "jvm", "metadata", "android" -> "$moduleName-$target"
//                else                         -> moduleName
//            }
//            artifactId = "ktd-$name"
//            version = versionConfiguration()
//            println("ARTIFACT: $artifactId:$version")
//        }
//    }
//    if (bool("publishAll") || bool(publishKey)) tasks.withType<AbstractPublishToMaven> { enabled = true }
//}
//
//fun Project.configureTdlibPublishing(): Unit = publishing(ktdTdlibPublisher, "publishTdlib", "tdlib") {
//    val libVersion = properties["libVersion"]!!.toString()
//    val tdVersion = properties["tdVersion"]?.toString()
//    if (tdVersion == "stable") libVersion else "$libVersion-$tdVersion"
//}
//
//fun Project.configureApiPublishing(name: String): Unit = publishing(ktdApiPublisher, "publishApi", name) {
//    val ktdVersion = properties["version"]!!.toString()
//    val tdVersion = properties["tdVersion"]?.toString()
//    if (tdVersion == "stable") ktdVersion else "$ktdVersion-$tdVersion"
//}
//
//fun Project.configurePublishing(name: String): Unit = publishing(ktdPublisher, "publishCore", name) {
//    properties["version"]!!.toString()
//}
