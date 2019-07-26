package kalisi

interface ServerConfig {

    val port: Int

    fun mount(application: Application): Server

}
