package 프로그래머스.모든문제

import java.util.*

fun main() {
    징검다리().solution(intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1), 3).let { println("답 : $it") }
}

class 징검다리 {
    fun solution(stones: IntArray, k: Int): Int {
        var crossCount = 0
        var newS = stones.map { Stone(it, 0) }

        while (true) {
            val tmp = LinkedList<Stone>()

            newS.fold(0) { skip, new ->
//                println("crossCount : $crossCount // skip : $skip")
                new.skip += skip

                println("crossCount : $crossCount  new Value = ${new.value}   new.skip : ${new.skip}")

                if (new.value - crossCount > 0) {
                    tmp.add(new)
                    0
                } else {
                    new.skip + 1
                }.also {
                    if (new.skip + 1 >= k){
                        println("osy  난데 $it")

                        return crossCount
                    } }
            }

            newS = tmp

            crossCount++

            println()
        }
    }

    data class Stone(val value: Int, var skip: Int)
}


/*
fun solution(stones: IntArray, k: Int): Int {
    var crossCount = 0

    while (true) {
        stones.fold(0) { skipCount, new ->
            val skip = if (new - crossCount > 0) 0 else skipCount + 1
            if (skip == k) return crossCount

            skip
        }
        crossCount++
    }
}*/
