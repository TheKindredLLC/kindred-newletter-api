rootProject.name = "kindred-newsletter-api"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://packages.confluent.io/maven/")
    }
}

include(":server")
include(":core")
include(":email:email-core")
include(":email:email-smtp")
include(":email:email-mock")
include(":email:email-service")
include(":email:email-template")
include(":storage:storage-core")
include(":storage:storage-sql")
include(":storage:storage-nosql")
include(":storage:storage-blob")
include(":scheduling:scheduling-core")
include(":scheduling:scheduling-memory")
include(":scheduling:scheduling-ktor-tasks")
include(":queueing:queueing-core")
include(":queueing:queueing-memory")
include(":queueing:queueing-ktor")
include(":tracking:tracking-core")
include(":tracking:tracking-pixel")
include(":tracking:tracking-click")
include(":tracking:tracking-ingest")
include(":campaign:campaign-core")
include(":campaign:campaign-batch")
include(":campaign:campaign-scheduling")
include(":campaign:campaign-execution")
include(":subscriber:subscriber-core")
include(":subscriber:subscriber-list")
include(":subscriber:subscriber-segmentation")
include(":subscriber:subscriber-compliance")
include(":organization:organization-core")
include(":organization:organization-auth")
include(":organization:organization-api-key")
include(":organization:organization-tenant")
include(":admin:admin-core")
include(":admin:admin-api")
include(":admin:admin-console")
include(":analytics")
include(":extension")
