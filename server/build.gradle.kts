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

    // Core modules
    // Admin
    // Admin subsystem
    implementation(project(":admin:admin-core"))
    implementation(project(":admin:admin-api"))
    implementation(project(":admin:admin-console"))

    // Core
    implementation(project(":core"))

    // Email
    implementation(project(":email:email-service"))

    // Storage
    implementation(project(":storage:storage-core"))
    implementation(project(":storage:storage-sql"))
    implementation(project(":storage:storage-nosql"))
    implementation(project(":storage:storage-blob"))

    // Scheduling
    implementation(project(":scheduling:scheduling-core"))
    implementation(project(":scheduling:scheduling-memory"))
    implementation(project(":scheduling:scheduling-ktor-tasks"))

    // Queueing
    implementation(project(":queueing:queueing-core"))
    implementation(project(":queueing:queueing-memory"))
    implementation(project(":queueing:queueing-ktor"))

    // Tracking
    implementation(project(":tracking:tracking-core"))
    implementation(project(":tracking:tracking-pixel"))
    implementation(project(":tracking:tracking-click"))
    implementation(project(":tracking:tracking-ingest"))

    // Campaign
    implementation(project(":campaign:campaign-core"))
    implementation(project(":campaign:campaign-scheduling"))
    implementation(project(":campaign:campaign-batch"))
    implementation(project(":campaign:campaign-execution"))

    // Subscriber
    implementation(project(":subscriber:subscriber-core"))
    implementation(project(":subscriber:subscriber-list"))
    implementation(project(":subscriber:subscriber-segmentation"))
    implementation(project(":subscriber:subscriber-compliance"))

    // Organization / Tenant
    implementation(project(":organization:organization-core"))
    implementation(project(":organization:organization-auth"))
    implementation(project(":organization:organization-api-key"))
    implementation(project(":organization:organization-tenant"))

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
