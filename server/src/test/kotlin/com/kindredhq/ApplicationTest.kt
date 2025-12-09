/*
 * Kindred Newsletter API
 * Copyright (c) 2025 The Kindred
 *
 * Licensed under the MIT License.
 *
 * See LICENSE file in the project root for full license information.
 */
package com.kindredhq

import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() =
        testApplication {
            application {
                module()
            }
            client.get("/").apply {
                assertEquals(HttpStatusCode.Companion.OK, status)
            }
        }
}
