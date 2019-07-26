package kalisi

interface Server {

    val port: Int

    fun start()
    fun stop()

}
