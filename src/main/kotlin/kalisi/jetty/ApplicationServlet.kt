package kalisi.jetty

import kalisi.Application
import kalisi.Request
import kalisi.Response
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

internal class ApplicationServlet(private val application: Application) : HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        return application(req.asAlisiRequest()).asServletResponse(resp)
    }
}

private fun HttpServletRequest.asAlisiRequest(): Request<String> = Request()

private fun Response<String>.asServletResponse(destination: HttpServletResponse) = destination.setStatus(status.code)
