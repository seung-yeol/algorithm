package 프로그래머스.코딩테스트_고득점_Kit.정렬

class 가장큰수 {
    fun solution(numbers: IntArray): String {
        return numbers.map { it.toString() }.sortedWith(Comparator { o1, o2 -> o2.plus(o1).compareTo(o1.plus(o2)) }).let {
            if (it.first() == "0") "0"
            else it.fold(StringBuffer()) { acc, s -> acc.append(s) }.toString()
        }
    }
} 