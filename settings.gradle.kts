pluginManagement {
    includeBuild("build-logic")
}

rootProject.name = "gradle-jpms-support"

include("module-a")
include("module-b")
include("module-c")
include("app")
include("module-java8")
include("module-kotlin")
include("module-multi-jdk-jars")
