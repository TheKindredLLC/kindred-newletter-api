plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}
kotlin {
    jvmToolchain(24)
}
dependencies {
    // Domain + email abstractions
    implementation(project(":core"))
    implementation(project(":email:email-core"))

    // Shared JSON handling for any internal DTOs
    implementation(libs.kotlinx.serialization)

    // Tests
    testImplementation(libs.kotlin.test.junit)
}
