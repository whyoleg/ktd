# Changelog

## 0.x.y
> Unreleased
- Split modules into client and api
- Api versioning based on tdlib version: 1.5.0 and 1.5.1
- From now `ktd` dependency will provide latest tdlib api version

## 0.3.0
> Published 2 Nov 2019
- Regenerate api based on tdlib 1.5.1
- Rework native bridge for more efficient implementation
- Rework handling of nullability and default values in scheme
- Use [kotlinx.collections.immutable](https://github.com/Kotlin/kotlinx.collections.immutable) for storing updates
- Add `BotsOnly` and `TestOnly` annotations
- Add extensions for synchronous functions
