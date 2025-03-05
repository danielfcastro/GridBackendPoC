plugins {
    id("java")
    id("org.flywaydb.flyway") version "11.3.3"
}

group = "com.ing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val flywayVersion = "11.3.3"
val lombokVersion = "1.18.20"

dependencies {
    implementation("org.flywaydb:flyway-core:$flywayVersion")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.h2database:h2:2.1.214")
    compileOnly ("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor ("org.projectlombok:lombok:$lombokVersion")
    runtimeOnly ("com.h2database:h2")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

repositories{
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

flyway {
    url="jdbc:h2:mem:testdb"
    user = "root"
    password="toor"
    schemas = arrayOf("test")
    locations = arrayOf("filesystem:src/main/resources/db/migration")
}
