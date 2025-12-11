plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    // Email abstractions
    implementation(project(":email:email-core"))

    // Markdown → HTML engine (CommonMark is lightweight and pure JVM)
    implementation(libs.commonmark.autolink)
    implementation(libs.commonmark.core)
    implementation(libs.commonmark.gfm)

    // JSON serialization for template metadata if needed
    implementation(libs.kotlinx.serialization)

    // Testing
    testImplementation(libs.kotlin.test.junit)
}
