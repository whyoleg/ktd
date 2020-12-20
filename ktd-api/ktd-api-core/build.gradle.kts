plugins {
    ids(Plugins.mppWithAndroidAndSerialization)
}
configureApi(KampModules.api, KampModules.tdlib)
configureSerialization()
//configureApiPublishing("api-core")
