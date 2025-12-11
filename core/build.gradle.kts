plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    // If the root project already configures the toolchain in `subprojects`, this is optional.
    jvmToolchain(24)
}

dependencies {
    // Core should remain lightweight — only language-level dependencies allowed.

    // Kotlin serialization is allowed because models will serialize between modules.
    implementation(libs.kotlinx.serialization)

    // Testing
    testImplementation(libs.kotlin.test.junit)
}
