package kalisi

import assertk.assertThat
import assertk.assertions.isEqualTo
import kalisi.Status.Companion.Ok
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object ResponseTest : Spek({

    describe("Response") {

        describe("map") {
            it("should map body") {
                assertThat(Response(Ok, "test").map{ it.toUpperCase() }.body).isEqualTo("TEST")
            }

            it("should preserve status") {
                assertThat(Response(Ok, "test").map{ it.toUpperCase() }.status).isEqualTo(Ok)
            }
        }

    }

})
