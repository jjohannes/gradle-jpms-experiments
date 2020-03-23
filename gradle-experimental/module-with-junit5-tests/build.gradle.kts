plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

dependencies {
    implementation(project(":module-with-junit4-tests"))
    implementation(project(":module-with-lib-dependency"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")

    implementation("net.rubygrapefruit:native-platform:0.21")
}

tasks.test {
    useJUnitPlatform()
}