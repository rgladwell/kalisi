package kalisi.jetty

import kalisi.Application
import kalisi.Request
import kalisi.Response
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

internal class ApplicationServlet(private val application: Application) : HttpServlet() {

    private fun HttpServletRequest.asAlisiRequest(): Request<Flow<Byte>> = Request()

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        return application(req.asAlisiRequest()).asServletResponse(resp)
    }

}

@UseExperimental(InternalCoroutinesApi::class)
private fun Response<Flow<Byte>>.asServletResponse(destination: HttpServletResponse) {
    destination.status = status.code

    val job = GlobalScope.launch {
        body.collect{ byte: Byte ->
            destination.outputStream.write(byte.toInt())
        }
    }

    runBlocking {
        job.join()
    }
}
