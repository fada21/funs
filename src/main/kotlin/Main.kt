fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    fun isEven(number: Int) = number.mod(2) == 0
    val list = (1..10).mapIf(::isEven) { times(2) }
    val listPlain = (1..10).map { if (it % 2 == 0) it * 2 else it }
    println("1..10 with doubled even numbers: $list")

    println("I wonder if single object transformation is any good.")
    val number = 1
    val one = number.transformIf(::isEven) { times(2) }
    val onePlain = if (isEven(number)) number.times(2) else 1
    val onePlainSimple = if (number % 2 == 0) number * 2 else 1


    val magazine = listOf(null, null, null, null, null, bullet)
    val m1 = magazine.toMutableList()
    val retries4 = retry(4, isOk = { it is bullet }, body = { m1.removeFirstOrNull() })
    println("Did hit bullet on 5th attempt: $retries4")
    val m2 = magazine.toMutableList()
    val retries5 = retry(5, isOk = { it is bullet }, body = { m2.removeFirstOrNull() })
    println("Did hit bullet on 6th attempt: $retries5")
}

object bullet
