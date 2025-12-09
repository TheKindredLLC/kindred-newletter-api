/*
 * Kindred Newsletter API
 * Copyright (c) 2025 The Kindred
 *
 * Licensed under the MIT License.
 *
 * See LICENSE file in the project root for full license information.
 */
package com.kindredhq

import io.github.flaxoos.ktor.server.plugins.ratelimiter.RateLimiting
import io.github.flaxoos.ktor.server.plugins.ratelimiter.implementations.TokenBucket
import io.ktor.server.application.Application
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import kotlin.time.Duration.Companion.seconds

private const val RATE_LIMIT_CAPACITY = 100
private val RATE_LIMIT_RATE = 10.seconds

fun Application.configureAdministration() {
    routing {
        route("/") {
            install(RateLimiting) {
                rateLimiter {
                    type = TokenBucket::class
                    capacity = RATE_LIMIT_CAPACITY
                    rate = RATE_LIMIT_RATE
                }
            }
        }
    }
}
