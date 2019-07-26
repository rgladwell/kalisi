package kalisi

import kotlinx.coroutines.flow.Flow

data class Request<T> private constructor(
    val body: T
) {
    companion object {
        operator fun invoke(): Request<Flow<Byte>> = Request(EmptyByteFlow)
    }
}
