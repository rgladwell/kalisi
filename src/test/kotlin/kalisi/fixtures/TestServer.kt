package kalisi.fixtures

import kalisi.Application
import kalisi.Server
import kalisi.jetty.Jetty

class TestServer(val app: Application) : Fixture<Server> {

    override val fixture = Jetty().mount(app)

    override fun before() {
        fixture.start()
    }

    override fun after() {
        fixture.stop()
    }

}