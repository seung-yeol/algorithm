package 프로그래머스.코딩테스트_고득점_Kit.힙

import java.util.*

class 이중우선순위큐 {
    fun solution(operations: Array<String>): IntArray {
        val pq1 = PriorityQueue<Int>()                              //작은거
        val pq2 = PriorityQueue<Int>(Collections.reverseOrder())    //큰거

        operations.asSequence().map { it.split(" ") }.forEach {
            if (it[0] == "I")
                it[1].toInt().let { value ->
                    pq1.add(value)
                    pq2.add(value)
                }
            else
                if (pq1.isNotEmpty())
                    it[1].toInt().let { value ->
                        if (value == 1) pq1.remove(pq2.poll())
                        else pq2.remove(pq1.poll())
                    }
        }

        return if (pq1.isNotEmpty()) {
            intArrayOf(pq2.poll(), pq1.poll())
        } else {
            intArrayOf(0, 0)
        }
    }
}