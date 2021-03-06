package 백준.SW역량테스트준비기초

import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val solver = 골드바흐의추측()

    do {
        val question = br.readLine().toInt()
        if (question == 0) return

        val answer = solver.solve(question)
        if (answer != null) println("$question = $answer + ${question - answer}")
        else println("Goldbach's conjecture is wrong.")
    } while (question != 0)
}

class 골드바흐의추측 {
    private val primeKeys = mutableListOf(2, 3)
    private val primeNums = Array(1000001) { false }

    init {
        primeNums[2] = true
        primeNums[3] = true
    }

    fun solve(n: Int): Int? {
        val lastPrimeNum = primeKeys.last()
        if ((lastPrimeNum) < n) (lastPrimeNum + 2..n step 2).forEach { primeNumberCheck(it) }

        return primeKeys.find { num -> if (n - num >= num) primeNums[n - num] else return null }
    }

    private fun primeNumberCheck(value: Int) {
        if ((3..sqrt(value.toFloat()).toInt() step 2).none { value % it == 0 }) {
            primeKeys.add(value)
            primeNums[value] = true
        }
    }
}