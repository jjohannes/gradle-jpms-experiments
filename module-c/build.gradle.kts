plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

tasks.test {
    useJUnitPlatform()
}

val integTest: SourceSet by sourceSets.creating
val integTestTask = tasks.register<Test>("integTest") {
    testClassesDirs = integTest.output.classesDirs
    classpath = integTest.runtimeClasspath
}
tasks.check {
    dependsOn(integTestTask)
}

dependencies {
    implementation(project(":module-b"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    "integTestImplementation"(project(path))
    "integTestImplementation"("org.junit.jupiter:junit-jupiter-api:5.6.0")
    "integTestRuntimeOnly"("org.junit.jupiter:junit-jupiter-engine")
}
