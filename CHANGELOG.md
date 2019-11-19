# Changelog

## 0.4.0
> Published 19 Nov 2019
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
> Published 2 Nov 2019
- Regenerate api based on tdlib 1.5.1
- Rework native bridge for more efficient implementation
- Rework handling of nullability and default values in scheme
- Use [kotlinx.collections.immutable](https://github.com/Kotlin/kotlinx.collections.immutable) for storing updates
- Add `BotsOnly` and `TestOnly` annotations
- Add extensions for synchronous functions
