plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktor)
}

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

kotlin {
    jvmToolchain(24)
}

dependencies {

    // Dependency Injection
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger)

    // Http
    implementation(libs.ktor.cors)
    implementation(libs.ktor.default.headers)
    implementation(libs.ktor.forwarded.header)
    implementation(libs.ktor.host.common)
    implementation(libs.ktor.status.pages)

    // KTOR Server
    implementation(libs.ktor.auth)
    implementation(libs.ktor.auth.jwt)
    implementation(libs.ktor.call.id)
    implementation(libs.ktor.call.logging)
    implementation(libs.ktor.config.yaml)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.netty)

    // Logging
    implementation(libs.logback)

    // Metrics
    implementation(libs.khealth)
    implementation(libs.ktor.micrometer)
    implementation(libs.micrometer)
    implementation(libs.opentelemetry)

    // Rate Limiting
    implementation(libs.rate.limiting)

    // Serialization
    implementation(libs.ktor.serialization)

    // Testing
    testImplementation(libs.ktor.test.host)
    testImplementation(libs.kotlin.test.junit)
}
