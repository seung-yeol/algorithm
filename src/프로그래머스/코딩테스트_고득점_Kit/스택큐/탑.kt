package 프로그래머스.코딩테스트_고득점_Kit.스택큐

import java.util.*

fun main(args: Array<String>) {
    println("답 : 0,0,2,2,4 // :" + 탑().solution(intArrayOf(6, 9, 5, 7, 4)).joinToString { "$it" })
}

class 탑 {
    fun solution(heights: IntArray): IntArray {
        val answer = IntArray(heights.size)
        val list = LinkedList<Pair<Int, Int>>(heights.indices.map { it + 1 }.zip(heights.toList()))
        val queue = LinkedList<Pair<Int, Int>>()

        while (list.isNotEmpty()) {
            val pair = list.peekLast()
            queue.filter { pair.second > it.second }
                    .also { queue.removeAll(it) }.forEach { answer[it.first - 1] = pair.first }
            queue.add(list.pollLast())
        }

        return answer
    }
}