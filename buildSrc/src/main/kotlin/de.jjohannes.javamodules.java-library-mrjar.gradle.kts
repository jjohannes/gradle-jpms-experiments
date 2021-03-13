import java.nio.file.Files
import org.gradle.api.plugins.jvm.internal.JvmPluginExtension
import org.gradle.api.plugins.jvm.internal.DefaultJvmPluginExtension

plugins {
    id("de.jjohannes.javamodules.java-library")
}

tasks.compileJava {
    options.release.set(8)
}

val jvm = extensions.create(JvmPluginExtension::class, "jvm", DefaultJvmPluginExtension::class)
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
