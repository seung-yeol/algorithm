package 프로그래머스.코딩테스트_고득점_Kit.스택큐

import java.util.*

fun main(args: Array<String>) {
    println(기능개발().solution(intArrayOf(93,30,55), intArrayOf(1,30,5)).joinToString { "$it " })
}

class 기능개발 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val queue = LinkedList<Pair<Int, Int>>( progresses.zip(speeds) )

        var i = 0
        while (queue.isNotEmpty()) {
            var count = 0
            i++

            run{
                while (queue.isNotEmpty()){
                    queue.peek().let {
                        if (it.first + it.second * i >= 100) {
                            count++
                            queue.pollFirst()
                        } else return@run
                    }
                }
            }
            if (count != 0) answer.add(count)
        }

        return answer.toIntArray()
    }
}