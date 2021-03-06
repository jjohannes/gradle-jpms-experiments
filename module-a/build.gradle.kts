plugins {
    id("de.jjohannes.javamodules.java-library")
}

tasks.jar {
    manifest {
        attributes("Automatic-Module-Name" to "org.module.a")
    }
}

dependencies {
    // 'native-platform' is not a module: no module-info.class, no Automatic-Module-Name
    // Therefore 'native-platform' will be put on the --classpath and is part of the UNNAMED module
    // Since this module - org.module.a - is an automatic module, it can access all modules (including the UNNAMED one)
    implementation("net.rubygrapefruit:native-platform:0.22-milestone-10")
}