allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

createBintrayPublishTask(ktdPublisher, version.toString())
createBintrayPublishTask(libPublisher, properties["libVersion"].toString())
