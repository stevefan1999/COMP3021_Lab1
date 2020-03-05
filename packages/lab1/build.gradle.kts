import org.anarres.gradle.plugin.sablecc.SableCC

plugins {
    application
    kotlin("jvm")
}

apply {
    plugin("sablecc")
}


dependencies {

}

application {
    mainClassName = "littlelang.Compiler"
}

tasks {
    withType<SableCC> {
    }
}
