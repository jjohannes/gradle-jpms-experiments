import java.nio.file.Files

plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val jvm = extensions.create(org.gradle.api.plugins.jvm.internal.JvmPluginExtension::class, "jvm", org.gradle.api.plugins.jvm.internal.DefaultJvmPluginExtension::class)
jvm.utilities.registerJvmLanguageSourceDirectory(sourceSets.main.get(), "java9") {
    withDescription("Java 9 Sources")
    compiledWithJava {
        options.release.set(9)
        classpath = sourceSets.main.get().compileClasspath

        options.compilerArgs.addAll(listOf(
            // so we can compile to another location
            "--patch-module", "org.java8compatible=${sourceSets.main.get().java.outputDir.path}"
        ))

        // This additional action is only needed if you want to build multi-release Jar
        doLast {
            val destRoot = destinationDirectory.get().asFile
            val destVersions9 = File(destRoot, "META-INF/versions/9").also { it.mkdirs() }
            destRoot.listFiles()?.forEach {
                if (it.name != "META-INF") {
                    Files.move(it.toPath(), File(destVersions9, it.name).toPath())
                }
            }
        }
    }
}

tasks.jar {
    manifest {
        attributes("Multi-Release" to true)
    }
}

