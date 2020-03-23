plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

val whiteboxClasspathTest: SourceSet by sourceSets.creating
val whiteboxModuleTest: SourceSet by sourceSets.creating
val whiteboxClasspathTestTask = tasks.register<Test>("whiteboxClasspathTest") {
    testClassesDirs = whiteboxClasspathTest.output.classesDirs
    classpath = whiteboxClasspathTest.runtimeClasspath
}

// The whitebox module tests are in: 'test' as that is configured by the plugin

tasks.check {
    dependsOn(whiteboxClasspathTestTask)
}

dependencies {
    testImplementation("junit:junit:4.13")
    "whiteboxClasspathTestImplementation"(project(path))
    "whiteboxClasspathTestImplementation"("junit:junit:4.13")
}