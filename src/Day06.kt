fun main() {

    fun part1(input: List<String>): Int {
        val inputString = input.toString().drop(1).dropLast(1)
        var index = 0
        var sublist = inputString.substring(index, 4)

        while (sublist.toList().toSet().size != sublist.toList().size) {
            index++
            sublist = inputString.substring(index, index + 4)
        }
        return index + 4
    }

    fun part2(input: List<String>): Int {
        val inputString = input.toString().drop(1).dropLast(1)
        var index = 0
        var sublist = inputString.substring(index, 14)

        while (sublist.toList().toSet().size != sublist.toList().size) {
            index++
            sublist = inputString.substring(index, index + 14)
        }
        return index + 14
    }

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}