package 서머코딩2017

import java.util.*

fun main(args: Array<String>) {
    println(배달().solution(5,
            arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 3, 1), intArrayOf(5, 2, 3), intArrayOf(1, 4, 2), intArrayOf(5, 3, 1), intArrayOf(5, 4, 2))
            , 3))

    println(배달().solution(6,
            arrayOf(intArrayOf(1, 2, 1), intArrayOf(1, 3, 2), intArrayOf(2, 3, 2), intArrayOf(3, 4, 3), intArrayOf(3, 5, 2), intArrayOf(3, 5, 3), intArrayOf(5, 6, 1))
            , 100))

    println(배달().solution(6,
            arrayOf(intArrayOf(1, 2, 1), intArrayOf(1, 3, 2), intArrayOf(2, 3, 2), intArrayOf(3, 4, 3), intArrayOf(3, 5, 2), intArrayOf(3, 5, 3), intArrayOf(5, 6, 1))
            , 0))
}

class 배달 {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val linkM = HashMap<Int, MutableList<TD>>().apply {
            road.groupBy({ it[0] }, { TD(it[1], it[2]) }).forEach { key, value ->
                put(key, getOrDefault(key, mutableListOf()).apply { addAll(value) })
            }
            road.groupBy({ it[1] }, { TD(it[0], it[2]) }).forEach { key, value ->
                put(key, getOrDefault(key, mutableListOf()).apply { addAll(value) })
            }
        }

        val delivery = HashSet<Int>().apply { add(1) }
        val shorts = IntArray(N) { 500001 }.also { it[0] = 0 }
        val nextTD = LinkedList<TD>()

        fun search(td: TD) {
            linkM[td.town]?.asSequence()!!.filter { td.distance + it.distance <= k }.map { TD(it.town, td.distance + it.distance) }.forEach {
                if (shorts[it.town - 1] > it.distance) {
                    shorts[it.town - 1] = it.distance

                    delivery.add(it.town)
                    nextTD.add(it)
                }
            }
        }

        search(TD(1, 0))
        while (nextTD.isNotEmpty()) {
            search(nextTD.pollFirst())
        }

        return delivery.size
    }

    data class TD(var town: Int, var distance: Int)
}