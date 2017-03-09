package example.kotlin

import example.kotlin.Car.Builder
import example.kotlin.Car.Builder.OK

fun main(args: Array<String>) {
    Builder.engine(Engine()).transmission(Transmission()).build()
    Builder.transmission(Transmission()).engine(Engine()).build()
    Builder.stereo(Stereo()).transmission(Transmission()).engine(Engine()).build()
//    Builder.stereo(example.kotlin.Stereo()).engine(example.kotlin.Engine()).build() //Compiler error
}

class Car internal constructor(private val a: Engine, private val b: Transmission, private val c: Stereo?) {
    override fun toString(): String {
        return "engine = $a, transmission = $b"
    }

    open class Builder<E, T> internal constructor(var engine: Engine?, var transmission: Transmission?, var stereo: Stereo?) {
        abstract class OK
        abstract class NO
        companion object : Builder<NO, NO>(null, null, null)

        fun engine(e: Engine): Builder<OK, T> {
            this.engine = e
            return Builder(e, transmission, stereo)
        }

        fun transmission(t: Transmission): Builder<E, OK> {
            this.transmission = t
            return Builder(engine, t, stereo)
        }

        fun stereo(s: Stereo): Builder<E, T> {
            this.stereo = s
            return Builder(engine, transmission, s)
        }
    }
}

class Engine
class Transmission
class Stereo

fun Builder<OK, OK>.build() = Car(this.engine!!, this.transmission!!, this.stereo)