plugins {
    id("java")
}

group = "org.example"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.0.0")
    testImplementation("org.mockito:mockito-core:4.11.0")
}

tasks.test {
    useJUnitPlatform()
}