plugins {
    kotlin("jvm") version "2.0.0"
}

group = "cn.tomsean"
version = "1.0-SNAPSHOT"

ext {
    set("slf4jVersion", "2.0.13")
    set("fastjsonVersion", "2.0.52")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    repositories {
        mavenCentral()
    }
    dependencies {
        implementation("org.slf4j:slf4j-api:${rootProject.ext.get("slf4jVersion")}")
        implementation("com.alibaba.fastjson2:fastjson2:${rootProject.ext.get("fastjsonVersion")}")

    }
}