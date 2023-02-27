import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TransformIfTests {

    @Test
    fun `should transform if condition met`() {
        0.transformIf(isEven) { plus(1) } shouldBe 1
    }

    @Test
    fun `should not transform if condition not met`() {
        1.transformIf(isEven) { plus(1) } shouldBe 1
    }

    @Test
    fun `should transform nullable`() {
        val address: String? = null
        address.transformIf({ !isNullOrEmpty() }) { (this as String).trim() } shouldBe null
    }

    @Test
    fun `should transform not null nullable`() {
        val address: String? = "   some address   "
        address.transformIf({ !isNullOrEmpty() }) { (this as String).trim() } shouldBe "some address"
    }


}

private val isEven: (Int) -> Boolean = { it.mod(2) == 0 }
private val isOdd: (Int) -> Boolean = { it.mod(2) == 1 }