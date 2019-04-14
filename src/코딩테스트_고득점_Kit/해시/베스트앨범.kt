package 코딩테스트_고득점_Kit.해시

import java.util.*

fun main(args: Array<String>) {
    println(베스트앨범().solution(arrayOf("a", "b", "a", "a", "b"), intArrayOf(500, 600, 150, 800, 2500)).joinToString { it.toString() })
    println(베스트앨범().solution(arrayOf("a", "b", "c", "d", "e"), intArrayOf(500, 600, 150, 800, 2500)).joinToString { it.toString() })
    println(베스트앨범().solution(arrayOf("a", "b", "a", "c", "d"), intArrayOf(500, 600, 500, 800, 2500)).joinToString { it.toString() })
    println(베스트앨범().solution(arrayOf("a", "a", "a", "c", "d"), intArrayOf(500, 500, 500, 800, 2500)).joinToString { it.toString() })
}

class 베스트앨범 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val map = HashMap<String, MutableList<Pair<Int, Int>>>()
        val sumMap: MutableMap<String, Int> = HashMap()
        val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 -> if (p1.second > p2.second) -1 else 1 }

        genres.forEachIndexed { index, s ->
            map[s] = map.getOrDefault(s, mutableListOf()).apply { add(Pair(index, plays[index])) }
            sumMap[s] = sumMap.getOrDefault(s, 1) + plays[index]
        }

        val list = LinkedList<Int>()
        sumMap.toList().sortedByDescending {
            it.second
        }.forEach { it ->
            pq.clear()
            pq.addAll(map[it.first]!!)

            list.add(pq.poll().first)
            if (pq.isNotEmpty()) {
                list.add(pq.poll().first)
            }
        }

        return list.toIntArray()
    }
}