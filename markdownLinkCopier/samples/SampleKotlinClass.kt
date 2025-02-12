fun main() {
    val sample = SampleKotlinClass()
    sample.printMessage("Hello!")
}

class SampleKotlinClass {

    fun printMessage(message: String) {
        println("Message: $message")
    }
}
