/*
 * Kindred Newsletter API
 * Copyright (c) 2025 The Kindred
 *
 * Licensed under the MIT License.
 *
 * See LICENSE file in the project root for full license information.
 */
package com.kindredhq

import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSecurity()
    configureMonitoring()
    configureSerialization()
    configureFrameworks()
    configureAdministration()
    configureRouting()
}
