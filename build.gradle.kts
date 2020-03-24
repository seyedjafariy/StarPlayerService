import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.61"
    war
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
    kotlin("plugin.jpa") version "1.3.61"
}
allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

group = "com.sajjady"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_13


val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}



repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // reactor
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.0.2.RELEASE")
    implementation("io.projectreactor.addons:reactor-adapter:3.3.2.RELEASE")
    // jsoup
    implementation("org.jsoup:jsoup:1.13.1")
    // import BOM
    implementation(platform("io.projectreactor:reactor-bom:Dysprosium-SR5"))
    // add dependencies without a version number
    implementation("io.projectreactor:reactor-core")
    implementation("io.projectreactor.addons:reactor-extra")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.+")


    // used for networking
    compileOnly("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    // database connection
    // runtimeOnly("com.h2database:h2")
   // implementation("com.github.jsimone:webapp-runner:8.5.11.3")


    runtimeOnly("mysql:mysql-connector-java")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
/*

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

task("stage") {
    dependsOn("clean", war)
}

tasks.war.get().setMustRunAfter*/

/*
tasks.get.doLast {
    delete {
        fileTree("build/distributions")
    }
    delete {
        fileTree("build/assetCompile")
    }
    delete {
        fileTree("build/distributions")
    }
    delete {
        fileTree("build/libs") {
            exclude("*.war")
        }
    }
}
*/
