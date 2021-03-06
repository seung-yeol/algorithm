package 프로그래머스.코딩테스트_고득점_Kit.완전탐색

fun main(args: Array<String>) {
    숫자야구().solution(arrayOf(intArrayOf(123, 0, 3)))
}

class 숫자야구 {
    fun solution(baseball: Array<IntArray>): Int {
        var answer = 0

        for (i in 123..987) {
            val toList = i.toString().toList()
            if (!toList.contains('0') && toList.foldIndexed(true) { index, acc, c ->
                        acc && toList.foldIndexed(true) { index2, acc2, c2 -> acc2 && if (index != index2) c != c2 else true }
                    }) {

                kotlin.run {
                    if (baseball.fold(true) { acc, it ->
                                if (!acc) return@run

                                val point = it[0].toString().toList()
                                var strike = 0
                                var ball = 0
                                point.forEachIndexed { index, c ->
                                    if (toList[index] == c) strike++
                                    else if (point.contains(toList[index])) ball++
                                }

                                acc && strike == it[1] && ball == it[2]
                            }) answer++
                }
            }
        }

        return answer
    }
}