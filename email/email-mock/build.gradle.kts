plugins {
    alias(libs.plugins.kotlin.jvm)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    implementation(project(":email:email-core"))

    // For testing usage later
    testImplementation(libs.kotlin.test.junit)
}
