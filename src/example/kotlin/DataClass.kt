package example.kotlin

/**
 * Created by breandanconsidine on 3/9/17.
 */

data class Building(var floors: Int, var base: Int)

fun main(args: Array<String>) {
    println(Building(1, 2))
}