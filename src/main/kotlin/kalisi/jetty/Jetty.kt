package kalisi.jetty

import kalisi.Application
import kalisi.Server
import kalisi.ServerConfig
import org.eclipse.jetty.server.ServerConnector
import org.eclipse.jetty.server.handler.HandlerWrapper
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS
import org.eclipse.jetty.servlet.ServletHolder
import javax.servlet.Servlet

import org.eclipse.jetty.server.Server as JettyServer

class Jetty(
    override val port: Int = (1024..49151).shuffled().first()
) : ServerConfig {

    override fun mount(application: Application): Server {
        val server = JettyServer().apply {
            insertHandler(ApplicationServlet(application).asJettyHandler())
        }

        val connector = ServerConnector(server)
            .apply {
                port = this@Jetty.port
                host = "127.0.0.1"
            }

        server.setConnectors(arrayOf(connector))

        return object : Server {
            override fun start() = server.start()
            override fun stop() = server.stop()
            override val port: Int = connector.port
        }
    }

}

internal fun Servlet.asJettyHandler(): HandlerWrapper =
    ServletContextHandler(SESSIONS).apply {
        addServlet(ServletHolder(this@asJettyHandler), "/*")
    }
