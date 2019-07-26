package kalisi

import kotlinx.coroutines.flow.Flow

typealias Application = Endpoint<Flow<Byte>, Flow<Byte>>
