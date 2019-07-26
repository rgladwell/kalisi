package kalisi

typealias Endpoint<I, O> = (Request<I>) -> Response<O>
