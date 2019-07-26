package kalisi

data class Response<T> private constructor(
    val status: Status,
    val body: T
) {
    companion object {
        operator fun invoke(status: Status): Response<String> = Response<String>(status,"")
    }
}
