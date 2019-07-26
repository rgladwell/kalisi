package kalisi

import kalisi.Status.Companion.Ok
import kalisi.jetty.Jetty
import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.rybalkinsd.kohttp.dsl.httpGet
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KalisiIntegrationTest : Spek({

    describe("kalisi") {
        it("should execute simple endpoint") {
            val server = Jetty().mount { Response(Ok) }
            server.start()

            val response = httpGet {
                host = "localhost"
                port = server.port
            }

            assertThat(response.code()).isEqualTo(Ok.code)

            server.stop()
        }
    }

})
