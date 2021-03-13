plugins {
    id("de.jjohannes.javamodules.java")
    id("java-library")
    id("maven-publish")
}

publishing {
    publications.create<MavenPublication>("library") {
        from(components["java"])
    }
    repositories.maven {
        url = uri(rootProject.layout.buildDirectory.dir("local-repo"))
    }
}
