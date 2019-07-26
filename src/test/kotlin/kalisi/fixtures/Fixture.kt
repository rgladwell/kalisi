package kalisi.fixtures

interface Fixture<T> {

    val fixture: T
    fun before()
    fun after()

    fun withFixture(test: (T) -> Unit) {
        before()
        try {
            test(fixture)
        } finally {
            after()
        }
    }

}
