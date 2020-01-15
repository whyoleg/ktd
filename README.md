# ktd

![](https://github.com/whyoleg/ktd/workflows/Build%20version/badge.svg)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
[![Download](https://api.bintray.com/packages/whyoleg/ktd/ktd/images/download.svg)](https://bintray.com/whyoleg/ktd/ktd/_latestVersion)

Library provide wrapper over [tdlib](https://github.com/tdlib/td) Telegram API using coroutines `Flow` and `suspend` functions.
For every tdlib function exists easy to use extension function with parameters and return type.

```kotlin
suspend fun TelegramClient.getChat(chatId: Long): Chat
``` 

For listening updates you can use flow with all updates:
```kotlin
val TelegramClient.updates: Flow<TelegramUpdate>
```

## Structure

`Telegram` - root factory object for creating `TelegramClient`. 
It will manage lifecycle of created clients.
`Telegram` implements `Job` interface and can be closed by calling `cancel()`
Optionally parent `Job` object can be passed as parameter to bind `Telegram` to existing lifecycle.
To configure low-level parameters for tdlib you can pass `TelegramClientConfiguration`.
- `receiveTimeout` - maximum duration allowed to wait for new data in one call to tdlib. 
By default 1 second.
Sufficient for most use cases but can be changed in future.
- `maxEventsCount` - maximum number of responses received from tdlib by one request. 
By default 1000.
Sufficient for most use cases but can be changed in future.

```kotlin
val telegram = Telegram(
    configuration = TelegramClientConfiguration(
        maxEventsCount = 100,
        receiveTimeout = 30.seconds
    )
)
```

`TelegramClient` can be created from `Telegram` and closed or independent by calling `cancel()` or by canceling `Telegram` object.
Using of client can be checked in [examples](https://github.com/whyoleg/ktd/tree/master/example/src/main/kotlin).
`TelegramClient` - main interface to interact with library. 

All extensions can be found in [api](https://github.com/whyoleg/ktd/tree/master/library/src/main/kotlin/dev/whyoleg/ktd/api) package.
They are grouped by type and exists in 2 kinds:
- Raw - just type binding for tdlib function:
```kotlin
suspend fun TelegramClient.chat(f: GetChat): Chat
``` 
- Parameterized - functions with inline parameters of function object:
```kotlin
suspend fun TelegramClient.getChat(chatId: Long): Chat
```
Result of calling this 2 functions will be the same. Parameterized functions just more easy to use and find.
 
Also `sync` package exists which contains functions which can be called synchronously using `TelegramClient` companion object.
 ```kotlin
fun TelegramClient.Companion.setLogVerbosityLevel(newVerbosityLevel: Int): Ok
``` 
Which can be used without `TelegramClient` instance like this:
```kotlin
TelegramClient.setLogVerbosityLevel(5)
```

To obtain updates, f.e. for chat last message, `updates` property on `TelegramClient` can be used:
```kotlin
client.updates.filterIsInstance<UpdateChatLastMessage>()
``` 

## Gradle build setup

```gradle
repositories {
    maven { 
        url "https://dl.bintray.com/whyoleg/ktd"
    }
}

dependencies {
    //just client independent on td api version
    implementation "dev.whyoleg.ktd:ktd-client-coroutines-jvm:0.5.0"
    //or for android
    implementation "dev.whyoleg.ktd:ktd-client-coroutines-android:0.5.0"
    //or for mpp common sourcSet
    implementation "dev.whyoleg.ktd:ktd-client-coroutines:0.5.0"
    
    //td api by version
    implementation "dev.whyoleg.ktd:ktd-api-coroutines-jvm:0.5.0-1.5.4"
    //or for android
    implementation "dev.whyoleg.ktd:ktd-api-coroutines-android:0.5.0-1.5.4"
    //or for another td api version
    implementation "dev.whyoleg.ktd:ktd-api-coroutines-jvm:0.5.0-1.5.0"
    //or for mpp common sourceSet
    implementation "dev.whyoleg.ktd:ktd-api-coroutines:0.5.0-1.5.4"
}
```

- Available artifacts:
  - Client: `dev.whyoleg.ktd:ktd-client-[type]-[platform]:[version]` - tdlib bindings
  - API: `dev.whyoleg.ktd:ktd-api-[type]-[platform]:[version]-[tdlib-version]` - generated API accessors
  - API stub: `dev.whyoleg.ktd:ktd-api-stub-[platform]:[version]` - [will be replaced or removed] use it with client as `compileOnly`
  to create new abstraction independent to API
- Supported configurations:
    - `version` - ktd version, f.e. 0.5.0
    - `type` - level of abstraction
      - `raw` - simple client with low-level bindings
      - `corotutines` - standard client with `suspend` functions for execution and `updates` Flow for consuming updates
      - `flow` - [will be available later]
    - `platform`
      - jvm
      - android 
      - metadata (common)
      - omit `platfrom` to use GRADLE_METADATA dependency
    - `tdlib-version`
      - v1.5.4
      - v1.5.3
      - v1.5.2
      - v1.5.1
      - v1.5.0

Now library published only to bintray, it will change in future.

## Status

For now, library has experimental status, so public interface can be changed any time until 1.0 version.
