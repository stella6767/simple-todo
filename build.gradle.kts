import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.nio.file.Path

plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("gg.jte.gradle") version "2.3.2"

    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
    kotlin("plugin.jpa") version "1.8.21"
}

val jteVersion = "2.3.2"

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


//jte {
//    precompile()
//}

//jte {
//    generate()
//}

jte {
    //sourceDirectory.set("src/main/kotlin")
    sourceDirectory.set(Path.of("src","main","kotlin"))
    precompile()
    generate()

}



repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {

    implementation("org.webjars:webjars-locator-core:0.52")
    implementation("org.webjars.npm:htmx.org:1.8.4")


    implementation("gg.jte:jte-spring-boot-starter-3:$jteVersion")
    // jte-kotlin is needed to compile kte templates
    implementation("gg.jte:jte-kotlin:$jteVersion")
    implementation("de.tschuehly:spring-view-component-jte:0.5.3")


    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-actuator")


    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Jar>{
    val resourcesDir = sourceSets.main.get().output.resourcesDir
    println("resourcesDir = $resourcesDir")

    from(resourcesDir)
}

sourceSets {
    test {
        resources {
            srcDir("src/test/kotlin")
            exclude("**/*.kt")
        }
    }
    main {
        resources {
            srcDir("src/main/kotlin")
            exclude("**/*.kt")
        }
    }
}