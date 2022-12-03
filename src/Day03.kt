fun main() {

    fun part1(input: List<String>): Int = input.fold(0) { sum: Int, rucksack: String ->
        sum + rucksack.getCommonItemPriority()
    }

    fun part2(input: List<String>): Int = input.chunked(3).fold(0) {sum: Int, group: List<String> ->
        sum + group.getGroupItemPriority()
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

private val Char.toPriority: Int
    get() = Priority.valueOf(this.toString()).value

private fun String.getCommonItemPriority() = chunked(length / 2).run {
    val firstCompartment = first().toSet()
    val secondCompartment = last().toSet()

    val commonItem = firstCompartment.intersect(secondCompartment).first()
    commonItem.toPriority
}

private fun List<String>.getGroupItemPriority(): Int {
    val firstRucksack = this[0].toSet()
    val secondRucksack = this[1].toSet()
    val thirdRucksack = this[2].toSet()

    return firstRucksack.intersect(secondRucksack).intersect(thirdRucksack).first().toPriority
}

enum class Priority(val value: Int) {
    a(1),
    b(2),
    c(3),
    d(4),
    e(5),
    f(6),
    g(7),
    h(8),
    i(9),
    j(10),
    k(11),
    l(12),
    m(13),
    n(14),
    o(15),
    p(16),
    q(17),
    r(18),
    s(19),
    t(20),
    u(21),
    v(22),
    w(23),
    x(24),
    y(25),
    z(26),
    A(27),
    B(28),
    C(29),
    D(30),
    E(31),
    F(32),
    G(33),
    H(34),
    I(35),
    J(36),
    K(37),
    L(38),
    M(39),
    N(40),
    O(41),
    P(42),
    Q(43),
    R(44),
    S(45),
    T(46),
    U(47),
    V(48),
    W(49),
    X(50),
    Y(51),
    Z(52),
}