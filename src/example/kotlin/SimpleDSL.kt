package example.kotlin

import example.kotlin.Company.Companion.company

fun main(args: Array<String>) {
    val sum = fun Int.(other: Int): Int = this + other
    val t = 1.sum(2)
    println(t)

    val company = company {
        ceo {
            firstName = "Tom"
            lastName = "Johnson"
            office { floor = 1 }
        }

        cio {
            lastName = "Hamilton"
            firstName = "Mary"
        }
    }

    println(company.ceo.firstName)
    println(company.ceo.office.floor)
}

class Company private constructor(val ceo: CEO, val cio: CIO) {
    private constructor(builder: CompanyBuilder) : this(builder.ceo, builder.cio)

    companion object {
        fun company(init: CompanyBuilder.() -> Unit) = Company(CompanyBuilder(init))
    }

    class CompanyBuilder private constructor() {
        constructor(init: CompanyBuilder.() -> Unit) : this() {
            init()
        }

        var ceo: CEO = CEO()
        var cio: CIO = CIO()

        fun ceo(init: CEO.() -> Unit) {
            init(ceo)
        }

        fun cio(init: CIO.() -> Unit) {
            init(cio)
        }
    }

    open class Person {
        lateinit var firstName: String
        lateinit var lastName: String
    }

    class CIO : Person() {}

    class CEO : Person() {
        var office: Office = Office()
        fun office(function: Office.() -> Unit) {
            function(office)
        }
    }
}

class Office {
    var floor: Int = 0
}
