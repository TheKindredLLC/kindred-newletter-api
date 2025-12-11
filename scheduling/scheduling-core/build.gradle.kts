plugins {
    alias(libs.plugins.kotlin.jvm)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    // Core contains only type definitions and interfaces.
    // No external libraries required at skeleton stage.
}
