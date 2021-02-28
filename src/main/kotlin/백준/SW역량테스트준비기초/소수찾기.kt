package 백준.SW역량테스트준비기초

fun main() {
    val br = System.`in`.bufferedReader()
    val solver = 소수찾기()

    br.readLine()

    val ints = br.readLine().split(" ").map { it.toInt() }
    println(solver.solve(ints.filter { it != 1 }))
}

class 소수찾기 {
    fun solve(ints: List<Int>): Int {
        return ints.filter { n -> (2 until n).none { n % it == 0 } }.size
    }
}