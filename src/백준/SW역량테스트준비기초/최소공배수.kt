package 백준.SW역량테스트준비기초

fun main() {
    val br = System.`in`.bufferedReader()
    val solver = 최소공배수()

    br.readLine()
    br.lines().forEach { line ->
        val (a, b) = line.split(" ").map { it.toInt() }

        println(solver.solve(a, b))
    }
}

class 최소공배수 {
    fun solve(a: Int, b: Int): Int {
        var aq: Int
        var bq: Int

        if (a > b) {
            aq = a
            bq = b
        } else {
            bq = a
            aq = b
        }

        while (true) {
            val remainder = aq % bq
            aq = bq
            bq = remainder

            if (remainder == 0) {
                return a * b / aq
            }
        }
    }
}