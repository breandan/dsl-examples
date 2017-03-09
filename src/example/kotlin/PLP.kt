package example.kotlin


class PLP private constructor(val name: String, val surname: String, val age: Int) {

    private constructor(builder: Builder) : this(builder.name, builder.surname, builder.age)

    companion object {
        fun create(init: Builder.() -> Unit) = Builder(init).build()
    }

    class Builder private constructor() {

        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        lateinit var name: String
        lateinit var surname: String
        var age: Int = 0

        fun name(init: Builder.() -> String) = apply { name = init() }

        fun surname(init: Builder.() -> String) = apply { surname = init() }

        fun age(init: Builder.() -> Int) = apply { age = init() }

        fun build() = PLP(this)
    }
}

fun main(args: Array<String>) {
    PLP.create {
        name { "Peter" }
        surname { "Slesarew" }
        age { 28 }
    }

    // OR

    PLP.create {
        name = "Peter"
        surname = "Slesarew"
        age = 28
    }
}
