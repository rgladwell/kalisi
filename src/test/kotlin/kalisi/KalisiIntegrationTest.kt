package kalisi

import kalisi.Status.Companion.Ok
import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.rybalkinsd.kohttp.dsl.httpGet
import kalisi.fixtures.TestServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KalisiIntegrationTest : Spek({

    describe("kalisi") {

        describe("with simple endpoint") {

            TestServer { Response(Ok).copy(body = "test-body") }.withFixture { server ->

                val response = httpGet {
                    host = "localhost"
                    port = server.port
                }

                it("should return HTTP status OK (200)") {
                    assertThat(response.code()).isEqualTo(200)
                }

            }

        }
    }

})
