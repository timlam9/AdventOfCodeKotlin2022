fun main() {

    fun parseStrategyGuide(input: List<String>) = input.map { line ->
        line.split(" ")
            .run {
                this[0].first() to this[1].first()
            }
    }

    fun part1(input: List<String>): Int = parseStrategyGuide(input)
        .fold(0) { totalScore, (elf, player) ->
            val elfGameSign = elf.toGameSign()
            val playerGameSign = player.toGameSign()

            val status = playerGameSign.calculateGameStatus(elfGameSign)

            totalScore + playerGameSign.value + status.value
        }


    fun part2(input: List<String>): Int = parseStrategyGuide(input)
        .fold(0) { totalScore, (elf, player) ->

            val elfGameSign = elf.toGameSign()
            val gameStatus = player.toGameStatus()

            val playerGameSign = gameStatus.calculatePlayerSign(elfGameSign)

            totalScore + playerGameSign.value + gameStatus.value
        }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}


fun GameStatus.calculatePlayerSign(elfGameSign: GameSigns): GameSigns {
    return when (this) {
        GameStatus.WIN -> elfGameSign.advantage()
        GameStatus.DRAW -> elfGameSign
        GameStatus.DEFEAT -> elfGameSign.disadvantage()
    }
}

private fun Char.toGameStatus(): GameStatus = when (this) {
    'X' -> GameStatus.DEFEAT
    'Y' -> GameStatus.DRAW
    else -> GameStatus.WIN
}

private fun Char.toGameSign(): GameSigns = GameSigns.values().first { it.elf == this || it.player == this }

enum class GameSigns(val elf: Char, val player: Char, val value: Int) {
    ROCK(elf = 'A', player = 'X', value = 1),
    PAPER(elf = 'B', player = 'Y', value = 2),
    SCISSOR(elf = 'C', player = 'Z', value = 3);

    fun advantage(): GameSigns = values().first { it.value - this.value == 1 || it.value - this.value == -2 }

    fun disadvantage(): GameSigns = values().first { it.value - this.value == -1 || it.value - this.value == 2 }
}

enum class GameStatus(val value: Int) {
    WIN(6), DRAW(3), DEFEAT(0)
}

fun GameSigns.calculateGameStatus(elfSign: GameSigns): GameStatus = when {
    value - elfSign.value == 1 || value - elfSign.value == -2 -> GameStatus.WIN
    value == elfSign.value -> GameStatus.DRAW
    else -> GameStatus.DEFEAT
}