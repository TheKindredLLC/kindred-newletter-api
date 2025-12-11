plugins {
    alias(libs.plugins.kotlin.jvm)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    implementation(project(":scheduling:scheduling-core"))

    // Coroutines will be required here eventually but NOT now.
    // Leave empty so skeleton stays minimal.
}
