plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_9
    targetCompatibility = JavaVersion.VERSION_1_9
}

tasks.jar {
    manifest {
        attributes("Automatic-Module-Name" to "org.nativestuff")
    }
}

dependencies {
    api("net.rubygrapefruit:native-platform:0.21")
}