import java.util.*

fun main() {
    fun part1(input: List<String>): String {
        val stacks = List(9) {
            Stack<Char>()
        }

        input.take(8).reversed().map { line ->
            line.forEachIndexed { index, char ->
                if (char.isLetter()) {
                    stacks[index / 4].push(char)
                }
            }
        }

        input.drop(10).map { line ->
            line.split(" ").mapIndexedNotNull { index, command -> if (index % 2 != 0) command.toInt() else null }
        }.forEach { (move, from, to) ->
            repeat(move) {
                stacks[to - 1].push(stacks[from - 1].pop())
            }
        }

        return stacks.joinToString("") { it.peek().toString() }
    }

    fun part2(input: List<String>): String {
        val stacks = List(9) {
            Stack<Char>()
        }

        input.take(8).reversed().map { line ->
            line.forEachIndexed { index, char ->
                if (char.isLetter()) {
                    stacks[index / 4].push(char)
                }
            }
        }

        input.drop(10).map { line ->
            line.split(" ").mapIndexedNotNull { index, command -> if (index % 2 != 0) command.toInt() else null }
        }.forEach { (move, from, to) ->
            val tempStack = Stack<Char>()
            repeat(move) {
                tempStack.push(stacks[from - 1].pop())
            }
            tempStack.reversed().forEach {
                stacks[to - 1].push(it)
            }
        }

        return stacks.joinToString("") { it.peek().toString() }
    }

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}