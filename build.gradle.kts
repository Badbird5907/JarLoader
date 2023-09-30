plugins {
    id("java")
}

group = "dev.badbird.jarloader"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.jar {
    // premain dev.badbird.jarloader.JarLoader
    manifest {
        attributes["Premain-Class"] = "dev.badbird.jarloader.JarLoader"
    }
}