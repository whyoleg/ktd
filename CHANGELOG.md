# Changelog

## 0.6.0
> Unreleased
###### That version contains many backward incompatible changes with provided deprecation migrations
###### That was done for future MPP support and creating `coroutines` independent clients 

##### API
- Use `tdlib` JSON interface instead of JNI
- Use `kotlinx.serialization` for MPP JSON support
- Use `sealed` classes instead of `abstract` classes
- All api requests now typed with response type
- Split `tdlib` api into 4 modules:
  - `core` - updates, responses and requests which can be used both by USERS and BOTS
  - `user` - requests which can be used ONLY by USERS
  - `bots` - requests which can be used ONLY by BOTS
  - `test` - requests and responses which can be used for testing, that `tdlib` works
- Separate modules with `suspend` api
- Repository now store only latest stable version of tdlib api, but all supported versions published
- Add support for `tdlib` `1.6.0` and `1.6.1` versions
- Now latest stable version: `1.6.0`

##### Core
- Remove `kotlinx.coroutines` from core dependencies 
- New basic client api to create custom clients based on callbacks
- Core modules:
  - `tdlib` - prebuilt version of `tdlib-json`
  - `json` - low-level bindings to `tdlib` JSON api
  - `core` - low-level api interfaces and clients to work with `tdlib`
  - `client` - default client and high-level client api: `AbstractTdClient` and `SynchronizedRunner`
- Clients based on `kotlinx.coroutines` extracted in separate dependencies
- `Flow` updates handler extracted in separate dependency

##### General
- Documentation added
- Tests added
- Benchmarks added
- Integration tests rewritten
- Migration from 0.5.0

## 0.5.0
> Released January 22, 2020
- Support Android: armeabi-v7a, arm64-v8a, x86, x86_64
- Support of tdlib `v1.5.2` - `v1.5.4`
- Generate changelog for `v1.5.1` - `v.1.5.4`
- Rename `TdClient` to `TelegramRawClient`
- Introduce `cli`
  - Build `tdlib` for supported platform/target
  - Generate kotlin api
  - Generate api changelog
  - Configured paths for dependencies and files through HOCON configuration
  - Create dispatch event to run tdlib build
  - Map libs to platforms
- Changed dependencies structure to make it easy to use and support multiplatform

## 0.4.1
> Released November 27, 2019
- Functions now have nullable `Ref` parameters
- Fix constructors counting of tl-scheme for `vector`
- Fix requests cancellation

## 0.4.0
> Released November 19, 2019
- Support Linux, MacOS, Win32 and Win64 using JVM
- Split modules into raw/coroutines client and raw/coroutines api
  - api dependency provide client dependency
- Api versioning based on tdlib version: 1.5.0 and 1.5.1 supported now
- From now there will be no `ktd` dependency
- Available dependencies:
  - `ktd-raw-client` - raw client contains bindings for interaction with `tdlib`
  - `ktd-raw-api-*` - raw api contains generated kotlin classes and built-in `tdlib` library for specific `tdlib` version
    - `ktd-raw-api-v1.5.0` 
    - `ktd-raw-api-v1.5.1`
    - `ktd-raw-api-latest` - for now latest = 1.5.1
  - `ktd-coroutines-client` - client with support of `suspend` and `Flow`
  - `ktd-coroutines-api-*` - contains generated fast accessors for api classes
    - `ktd-coroutines-api-v1.5.0` 
    - `ktd-coroutines-api-v1.5.1` 
    - `ktd-coroutines-api-latest`  - for now latest = 1.5.1
  - `ktd-api-stub` - api stub that can be used in `compileOnly` scope with `ktd-*-client` dependency

## 0.3.0
> Released November 2, 2019
- Regenerate api based on tdlib 1.5.1
- Rework native bridge for more efficient implementation
- Rework handling of nullability and default values in scheme
- Use [kotlinx.collections.immutable](https://github.com/Kotlin/kotlinx.collections.immutable) for storing updates
- Add `BotsOnly` and `TestOnly` annotations
- Add extensions for synchronous functions
