plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    implementation(project(":subscriber:subscriber-core"))
    implementation(libs.kotlinx.serialization)
}
