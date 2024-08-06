plugins {
    kotlin("jvm")
}

group = "cn.tomsean"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    api(project(":util"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}