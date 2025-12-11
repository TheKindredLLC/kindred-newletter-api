plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    implementation(libs.kotlinx.serialization)

    testImplementation(libs.kotlin.test.junit)
}
