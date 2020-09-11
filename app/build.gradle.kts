plugins {
    id("de.jjohannes.javamodules.java-application")
}

version = "1.0-final"

application {
    mainModule.set("org.app")
    mainClass.set("org.app.AppMain")
}

tasks.compileJava {
    options.javaModuleMainClass.set("org.app.AppMain")
}

dependencies {
    implementation(project(":module-c"))
}