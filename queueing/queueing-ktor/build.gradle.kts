plugins {
    alias(libs.plugins.kotlin.jvm)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    implementation(project(":queueing:queueing-core"))
    // No Ktor dependencies yet — added later during server integration.
}
