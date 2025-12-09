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
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureFrameworks() {
    install(Koin) {
        slf4jLogger()
        modules(
            module {
                single<HelloService> {
                    HelloService {
                        println(environment.log.info("Hello, World!"))
                    }
                }
            },
        )
    }
}
