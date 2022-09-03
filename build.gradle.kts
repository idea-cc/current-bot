plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "live.shuuyu"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://maven.kotlindiscord.com/repository/maven-snapshots/")
    maven("https://maven.kotlindiscord.com/repository/maven-releases/")
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
    maven("https://schlaubi.jfrog.io/artifactory/lavakord")
    maven("https://jitpack.io")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

val shadowMe: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

dependencies {
    shadowMe("ch.qos.logback:logback-classic:1.2.11")
    shadowMe("org.codehaus.groovy:groovy:3.0.12")
    shadowMe("com.kotlindiscord.kord.extensions:kord-extensions:1.5.5-SNAPSHOT")
    shadowMe("io.ktor:ktor-serialization-kotlinx-json-jvm:2.1.0")
    shadowMe("io.ktor:ktor-client-core-jvm:2.1.0")
    shadowMe("io.ktor:ktor-client-cio-jvm:2.1.0")
    shadowMe("io.ktor:ktor-client-content-negotiation-jvm:2.1.0")
}

tasks {
    "shadowJar"(com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar::class) {
        configurations = listOf(shadowMe)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    "compileKotlin"(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "17"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.contracts.ExperimentalContracts"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
            kotlinOptions.freeCompilerArgs += "-opt-in=kotlinx.serialization.InternalSerializationApi"
        }
    }
    "compileJava"(JavaCompile::class) {
        options.encoding = "UTF-8"
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}