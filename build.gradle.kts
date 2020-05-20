plugins {
    kotlin("jvm") version "1.3.72"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("io.gitlab.arturbosch.detekt") version "1.9.1"
}

group = "com.hxdcml.stockt"
version = "1.0.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    detekt {
        config = files("detekt.yml")
    }
}