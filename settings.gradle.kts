@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.kotlindiscord.com/repository/maven-snapshots/")
        maven("https://maven.kotlindiscord.com/repository/maven-releases/")
        maven("https://maven.kotlindiscord.com/repository/maven-public/")
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

rootProject.name = "Miu"

include(":bot:commands")
include(":bot:utils")
include(":bot:core")
include(":bot:database")
include(":bot:phishing")

include(":microservices:statistics")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            ktor()
            kotlinLibs()
            kordLibs()
            databaseLibs()
        }
    }
}

fun VersionCatalogBuilder.ktor() {
    val ktorVersion = "2.1.0"

    library("ktor-client-json", "io.ktor", "ktor-client-json").version(ktorVersion)
    library("ktor-client-websockets", "io.ktor", "ktor-client-websockets").version(ktorVersion)
    library("ktor-server-core-jvm", "io.ktor", "ktor-server-core-jvm").version(ktorVersion)
    library("ktor-client-core-jvm", "io.ktor", "ktor-client-core-jvm").version(ktorVersion)
    library("ktor-client-cio-jvm", "io.ktor", "ktor-client-cio-jvm").version(ktorVersion)
    library("ktor-client-content-negotiation-jvm", "io.ktor", "ktor-client-content-negotiation-jvm").version(ktorVersion)

    bundle(
        "ktor-bundle", listOf(
            "ktor-client-json",
            "ktor-client-websockets",
            "ktor-server-core-jvm",
            "ktor-client-core-jvm",
            "ktor-client-cio-jvm",
            "ktor-client-content-negotiation-jvm",
        )
    )
}

fun VersionCatalogBuilder.kotlinLibs() {
    val kotlinVersion = version("kotlin", "1.7.10")
    val coroutineVersion = version("coroutuine", "1.6.4")
    val serializationVersion = version("serialization", "1.4.0")
    val atomicfuVersion = version("atomicfu", "0.18.3")

    library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").versionRef(kotlinVersion)
    library("kotlin-stdlib-jdk7", "org.jetbrains.kotlin", "kotlin-stdlib-jdk7").versionRef(kotlinVersion)
    library("kotlin-stdlib-jdk8", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8").versionRef(kotlinVersion)
    library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef(kotlinVersion)
    library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef(coroutineVersion)
    library("kotlinx-coroutines-core-jvm", "org.jetbrains.kotlinx", "kotlinx-coroutines-core-jvm").versionRef(coroutineVersion)
    library("kotlinx-coroutines-jdk8", "org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8").versionRef(coroutineVersion)
    library("kotlinx-serialization", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef(serializationVersion)
    library("kotlinx-serialization-core-jvm", "org.jetbrains.kotlinx", "kotlinx-serialization-core-jvm").versionRef(serializationVersion)
    library("kotlinx-serialization-json-jvm", "org.jetbrains.kotlinx", "kotlinx-serialization-json-jvm").versionRef(serializationVersion)
    library("atomicfu", "org.jetbrains.kotlinx", "atomicfu").versionRef(atomicfuVersion)

    bundle(
        "kotlinLibs-bundle", listOf(
            "kotlin-stdlib",
            "kotlin-stdlib-jdk7",
            "kotlin-stdlib-jdk8",
            "kotlin-reflect",
            "kotlinx-coroutines-core",
            "kotlinx-coroutines-core-jvm",
            "kotlinx-coroutines-jdk8",
            "atomicfu",
        )
    )
}

fun VersionCatalogBuilder.kordLibs() {
    val kordVersion = "0.8.x-SNAPSHOT"
    val interaktionsVersion = "0.0.17-20220915.223922-13"

    library("kord-core", "dev.kord", "kord-core").version(kordVersion)
    library("gateway-kord", "net.perfectdreams.discordinteraktions", "gateway-kord").version(interaktionsVersion)

    bundle("kordLibs-bundle", listOf(
            "kord-core",
            "gateway-kord"
        )
    )
}

fun VersionCatalogBuilder.databaseLibs() {
    val postgresVersion = "42.5.0"
    val exposedVersion = "0.39.2"

    library("postgresql", "org.postgresql", "postgresql").version(postgresVersion)
    library("exposed-core", "org.jetbrains.exposed", "exposed-core").version(exposedVersion)
    library("exposed-kotlin-datetime", "org.jetbrains.exposed", "exposed-kotlin-datetime").version(exposedVersion)
    library("exposed-jdbc", "org.jetbrains.exposed", "exposed-jdbc").version(exposedVersion)

    bundle( "database-bundle", listOf(
        "postgresql",
        "exposed-core",
        "exposed-kotlin-datetime",
        "exposed-jdbc"
    ))
}