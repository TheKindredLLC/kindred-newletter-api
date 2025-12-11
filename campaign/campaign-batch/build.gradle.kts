plugins {
    alias(libs.plugins.kotlin.jvm)
}

kotlin {
    jvmToolchain(24)
}

dependencies {
    implementation(project(":campaign:campaign-core"))
}
