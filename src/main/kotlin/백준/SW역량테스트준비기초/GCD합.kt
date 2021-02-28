package 백준.SW역량테스트준비기초

fun main() {
    val br = System.`in`.bufferedReader()
    val solver = GCD합()

    br.readLine()
    br.lines().forEach { line ->
        val ints = line.split(" ").map { it.toInt() }

        println(solver.solve(ints.drop(1)))
    }
}

class GCD합 {
    fun solve(ints: List<Int>): Long {
        return ints.foldIndexed(0L) { index, acc, x ->
            acc + ints.drop(index + 1).fold(0L) { yAcc, y -> yAcc + gcd(x, y) }
        }
    }

    fun gcd(a: Int, b: Int): Int {
        return if (a >= b) internalGcd(a, b) else internalGcd(b, a)
    }

    private fun internalGcd(a: Int, b: Int): Int {
        return (a % b).let { if (it == 0) b else internalGcd(b, it) }
    }
}