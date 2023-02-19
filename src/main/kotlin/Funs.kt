inline fun <T> T.transformIf(predicate: T.() -> Boolean, transform: T.() -> T): T =
    if (this.predicate()) this.transform() else this

inline fun <T> Iterable<T>.mapIf(predicate: T.() -> Boolean, transform: T.() -> T): Iterable<T> =
    map { it.transformIf(predicate, transform) }