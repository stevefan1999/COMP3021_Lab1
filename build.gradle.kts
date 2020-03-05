import org.anarres.gradle.plugin.sablecc.SableCC
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


allprojects {
    apply<JavaPlugin>()
    apply<KotlinPlatformJvmPlugin>()

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        implementation(kotlin("stdlib"))
        implementation(kotlin("stdlib-jdk8"))
        implementation("com.google.code.findbugs", "jsr305", "3.0.2")

        testImplementation("org.junit.jupiter", "junit-jupiter-params", "5.6.0")
        testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.0")
        testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.6.0")
    }

    group = "hk.edu.polyu.19037626d"
    version = "1.0-SNAPSHOT"

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

buildscript {
    dependencies {
        classpath("org.anarres.gradle:gradle-sablecc-plugin:1.0.5")
    }
}

plugins {
    java
    kotlin("jvm") version "1.3.61"
}



