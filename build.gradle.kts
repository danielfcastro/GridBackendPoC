plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.flywaydb.flyway") version "9.16.3"
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.spring") version "1.8.10"
}

group = "com.ing.grid"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

flyway {
    url = "jdbc:h2:mem:testdb"
    user = "sa"
    password = "password"
    locations = arrayOf("filesystem:src/main/java/resources/db/migration")
}