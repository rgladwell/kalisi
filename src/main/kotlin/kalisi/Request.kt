package kalisi

data class Request<T> private constructor(
    val body: T
) {
    companion object {
        operator fun invoke(): Request<String> = Request<String>("")
    }
}
