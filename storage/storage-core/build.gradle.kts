plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    // JSON support for request/response metadata if needed
    implementation(libs.kotlinx.serialization)

    // Tests
    testImplementation(libs.kotlin.test.junit)
}
