package 프로그래머스.코딩테스트_고득점_Kit.해시

import java.util.*

fun main(args: Array<String>){
}
class 위장 {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map = HashMap<String, MutableList<String>>()

        clothes.forEach {
            val key = it[1]
            map[key] = map.getOrDefault(key, LinkedList()).apply { add(it[0]) }
        }

        map.values.forEach{
            answer *= it.size + 1 //+1은 부위 별 아무것도 안 입은경우 추가
        }

        return answer-- //진짜 아아아아무것도 안 입은경우 뺌
    }
}