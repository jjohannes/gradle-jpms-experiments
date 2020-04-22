plugins {
    `java-library`
    kotlin("jvm") version "1.3.72"
    id("de.jjohannes.extra-java-module-info") version "0.1"
}

extraJavaModuleInfo {
    automaticModule("kotlin-stdlib-1.3.72.jar", "kotlin.stdlib")
    automaticModule("kotlin-stdlib-common-1.3.72.jar", "kotlin.stdlib.common")
    automaticModule("annotations-13.0.jar", "org.jetbrains.annotations")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.google.code.gson:gson:2.8.6")
}
