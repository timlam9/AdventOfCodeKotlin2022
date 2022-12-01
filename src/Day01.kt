fun main() {

    fun sublistToSums(input: List<String>) = input.fold(mutableListOf(0)) { acc: MutableList<Int>, item ->
        when {
            item.isNotEmpty() -> acc[acc.lastIndex] = acc[acc.lastIndex] + item.toInt()
            else -> acc.add(0)
        }
        acc
    }

    fun part1(input: List<String>): Int = sublistToSums(input).max()

    fun part2(input: List<String>): Int = sublistToSums(input)
            .sortedDescending()
            .take(3)
            .sum()

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
