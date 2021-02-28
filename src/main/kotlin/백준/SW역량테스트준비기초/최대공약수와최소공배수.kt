package 백준.SW역량테스트준비기초

fun main() {
    val br = System.`in`.bufferedReader()

    val (a, b) = br.readLine().split(" ").map { it.toInt() }

    최대공약수와최소공배수().solve(a, b).let {
        println(it.first)
        println(it.second)
    }
}

class 최대공약수와최소공배수 {
    fun solve(a: Int, b: Int): Pair<Int, Int> {
        return 최대공약수(a, b).let { it to a * b / it }
    }

    private fun 최대공약수(a: Int, b: Int): Int {
        return recursive(a, b)
    }

    private fun recursive(a: Int, b: Int): Int {
        return (2..a.coerceAtLeast(b))
            .asSequence()
            .mapNotNull { quotientsWithDivider(a, b, it) }
            .firstOrNull()?.let { (aQ, bQ, divider) ->
                divider * recursive(aQ, bQ)
            } ?: 1
    }

    private fun quotientsWithDivider(a: Int, b: Int, divider: Int): Triple<Int, Int, Int>? {
        return if (a % divider == 0 && b % divider == 0) Triple(a / divider, b / divider, divider) else null
    }
}