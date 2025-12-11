plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    implementation(project(":core"))
    implementation(project(":email:email-core"))

    implementation(libs.smtp.email)

    implementation(libs.kotlinx.serialization)

    testImplementation(libs.kotlin.test.junit)
}
