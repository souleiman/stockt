plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"

    jacoco
    id("org.springframework.boot") version "2.3.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"

    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("io.gitlab.arturbosch.detekt") version "1.9.1"
    id("com.adarshr.test-logger") version "2.0.0"
}

group = "com.hxdcml.stockt"
version = "1.0.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // Spring Framework
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")

    kapt(group = "org.springframework.boot", name = "spring-boot-configuration-processor")
    annotationProcessor(group = "org.springframework.boot", name = "spring-boot-configuration-processor")

    // Swagger UI
    implementation(group = "io.springfox", name = "springfox-swagger-ui", version = "2.9.2")
    implementation(group = "io.springfox", name = "springfox-swagger2", version = "2.9.2")

    // Logging
    implementation(group = "io.github.microutils", name = "kotlin-logging", version = "1.7.9")

    // Jackson
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-core", version = "2.11.0")
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-databind", version = "2.11.0")
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-annotations", version = "2.11.0")
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = "2.11.0")
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-parameter-names", version = "2.11.0")
    implementation(group = "com.fasterxml.jackson.datatype", name = "jackson-datatype-jdk8", version = "2.11.0")
    implementation(group = "com.fasterxml.jackson.datatype", name = "jackson-datatype-jsr310", version = "2.11.0")

    testImplementation(group = "org.springframework.boot", name = "spring-boot-starter-test")

    testImplementation(kotlin("test-junit5"))
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.6.2")
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.6.2")

    testImplementation(group = "org.mockito", name = "mockito-core", version = "3.3.3")
    testImplementation(group = "org.mockito", name = "mockito-junit-jupiter", version = "3.3.3")
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

    test {
        useJUnitPlatform()
    }

    jacoco {
        toolVersion = "0.8.5"
        reportsDir = file("$buildDir/reports/jacoco")
    }

    jacocoTestReport {
        group = "reporting"

        reports {
            xml.isEnabled = true
            html.isEnabled = true
            csv.isEnabled = false

            xml.destination = file("$buildDir/reports/jacoco.xml")
            html.destination = file("$buildDir/reports/jacocoHtml")
        }

        val matching = sourceSets.main.get().output.asFileTree.matching {
            exclude("**/config/**", "**/Application*.*")
        }

        classDirectories.setFrom(matching)
    }
}