plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {

    implementation(project(":storage:storage-core"))

    implementation(libs.kotlinx.serialization)

    // Tests
    testImplementation(libs.kotlin.test.junit)
}
