plugins {
    id("java")
    id("io.freefair.lombok") version "8.11"
}

group = "me.hermippus"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.withType(Jar::class) {
    manifest {
        attributes["Manifest-Version"] = "1.0"
        attributes["Main-Class"] = "me.hermippus.Main"
    }
}