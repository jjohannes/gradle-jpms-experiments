Example for using the JPMS support of Gradle 6.4:

- [module-a](module-a) And automatic module with a dependency to a pure library
- [module-b](module-b) A module with JUnit 4 unit (whitebox) tests - using module patching - and integration (blackbox) tests
- [module-c](module-c) A module with JUnit 5 unit (whitebox) tests - using classpath - and integration (blackbox) tests
- [app](app) Application running as module
- [module-java8](module-java8) A module that can also be used as a normal library with Java 8

Run the sample:
- Run tests `./gradlew check`
- Run modular application `./gradlew app:run`
- Build all `./gradlew build`
  - Packaged application can be found in:  app/build/distributions/app-1.0-final.zip