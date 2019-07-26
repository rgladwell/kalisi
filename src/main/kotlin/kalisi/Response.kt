package kalisi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

data class Response<T>(
    val status: Status,
    val body: T
) {

    fun <S> map(f: (T) -> S): Response<S> = Response<S>(status = status, body = f(body))

    fun withBody(s: String): Response<Flow<Byte>> = map{ s.toByteArray().toList().asFlow() }

    companion object {

        operator fun invoke(status: Status): Response<Flow<Byte>> = Response(status, EmptyByteFlow)

    }

}
