package example.kotlin

class Person constructor(private var firstName: String, private var lastName: String, private val age: Int = 0) {
    override fun toString(): String {
        return "firstName: $firstName, lastName: $lastName, age: $age"
    }

    fun changeName(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }
}

fun main(args: Array<String>) {
    val p = Person(lastName = "Moolenar", firstName = "Bram")
    p.changeName(lastName = "Jennings", firstName = "Tom")
}
