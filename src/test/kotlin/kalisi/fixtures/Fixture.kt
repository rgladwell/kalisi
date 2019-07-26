package kalisi.fixtures

interface Fixture<T> {

    val fixture: T
    fun before()
    fun after()

    fun withFixture(test: T.(T) -> Unit) {
        before()
        try {
            fixture.test(fixture)
        } finally {
            after()
        }
    }

}
