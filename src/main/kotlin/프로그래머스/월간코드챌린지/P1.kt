package 프로그래머스.월간코드챌린지

import java.util.*
import kotlin.math.pow

fun main() {
    println(P1().solution(45))
}

class P1 {
    fun solution(n: Int): Int {
        var answer: Int = 0

        var tmp = n
        val list = LinkedList<Int>()
        while (tmp / 3 != 0) {
            list.add(tmp % 3)
            tmp /= 3
        }
        list.add(tmp)
        list.reversed().forEachIndexed { index, i ->
            answer += i * 3.toDouble().pow(index.toDouble()).toInt()
        }

        return answer
    }
}