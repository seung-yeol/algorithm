package 프로그래머스.코딩테스트_고득점_Kit.힙

import java.util.*

fun main(args: Array<String>) {
    println(디스크_컨트롤러().solution(arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))))
}

class 디스크_컨트롤러 {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var time = 0

        var resumeP = 0
        val pq = PriorityQueue<IntArray>(kotlin.Comparator { o1, o2 -> if (o1[1] >= o2[1]) 1 else -1 })
        Arrays.sort(jobs) { o1, o2 -> if (o1[0] >= o2[0]) 1 else -1 }   // input 시간순서대로 정렬 안되있대요.

        while (resumeP != jobs.size) {
            if (pq.isEmpty() && time < jobs[resumeP][0]) time = jobs[resumeP][0]
            pq.addAll(jobs.asSequence().drop(resumeP).takeWhile { it[0] <= time }.also { resumeP += it.count() }.toList())

            val poll = pq.poll()
            answer += time - poll[0] + poll[1]
            time += poll[1]
        }

        while (pq.isNotEmpty()){
            val poll = pq.poll()
            answer += time - poll[0] + poll[1]
            time += poll[1]
        }

        return answer / jobs.size
    }
}