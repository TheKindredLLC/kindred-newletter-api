plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    implementation(libs.kotlinx.serialization)
    implementation(project(":organization:organization-core"))

    testImplementation(libs.kotlin.test.junit)
}
