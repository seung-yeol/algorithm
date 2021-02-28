package 백준.SW역량테스트준비기초

fun main() {
    val br = System.`in`.bufferedReader()

    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    나머지().solve(a, b, c).forEach { println(it) }
}

class 나머지 {
    fun solve(a: Int, b: Int, c: Int): IntArray {
        return intArrayOf((a + b) % c, ((a % c) + (b % c)) % c, (a * b) % c, ((a % c) * (b % c)) % c)
    }
}