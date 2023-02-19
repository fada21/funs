import java.lang.Exception

public inline fun <T> T.transformIf(predicate: T.() -> Boolean, transform: T.() -> T): T =
    if (this.predicate()) this.transform() else this

public inline fun <T> Iterable<T>.mapIf(predicate: T.() -> Boolean, transform: T.() -> T): Iterable<T> =
    map { it.transformIf(predicate, transform) }

public inline fun <T> retry(
    count: Int = 1,
    isOk: (T) -> Boolean,
    body: () -> T): T? {
    repeat(count) {
        try {
            body().takeIf(isOk)?.let { return it }
        } catch (e: Exception) {
            // ¯\_(ツ)_/¯ // who cares, maybe next time
        }
    }
    return body().takeIf(isOk)
}
