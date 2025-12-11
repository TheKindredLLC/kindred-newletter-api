plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    // Email core depends on the domain core
    implementation(project(":core"))

    // JSON serialization for email messages
    implementation(libs.kotlinx.serialization)

    // Unit testing
    testImplementation(libs.kotlin.test.junit)
}
