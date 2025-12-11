plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    // Core storage abstractions
    implementation(project(":storage:storage-core"))

    // For any serialization of query results or metadata
    implementation(libs.kotlinx.serialization)

    // Tests
    testImplementation(libs.kotlin.test.junit)
}
