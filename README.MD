Example for using the JPMS support available since Gradle 6.4 (current version of the sample requires **Gradle 6.7+**):

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
- Publish modules to a local repository `./gradlew publish`

If you need to work (and patch) existing legacy JARs, the 
[de.jjohannes.extra-java-module-info](https://github.com/jjohannes/extra-java-module-info/blob/master/README.md#how-to-use-this-plugin)
plugin might also come in handy.