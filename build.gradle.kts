plugins {
    id("java")
    id("java-test-fixtures")
}

group = "com.github.ppzxc"
version = "0.0.2"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.assertj:assertj-core:3.24.2")

    testFixturesImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:1.0.13")
    testFixturesImplementation("com.navercorp.fixturemonkey:fixture-monkey-jackson:1.0.13")
}

tasks.test {
    useJUnitPlatform()
}