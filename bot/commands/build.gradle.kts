plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.kotlindiscord.com/repository/maven-snapshots/")
}

dependencies {
    implementation(project(":bot:common"))

    implementation(libs.bundles.kotlinLibs.bundle)
    implementation(libs.bundles.ktor.bundle)
    implementation(libs.bundles.kordLibs.bundle)
}

tasks {
    "compileKotlin"(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf(
                "-opt-in=kotlin.RequiresOptIn",
                "-opt-in=kotlin.contracts.ExperimentalContracts",
                "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
                "-opt-in=kotlinx.serialization.InternalSerializationApi"
            )
        }
    }
    "compileJava"(JavaCompile::class) {
        options.encoding = "UTF-8"
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
    }
}