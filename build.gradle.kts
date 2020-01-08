//import dev.whyoleg.kamp.*
//
//kampRoot {
//    plugins(Plugins.updates)
//}
//
//registerTasks()

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

createBintrayPublishTask(ktdPublisher)
createBintrayPublishTask(cliPublisher)
createBintrayPublishTask(libPublisher)
