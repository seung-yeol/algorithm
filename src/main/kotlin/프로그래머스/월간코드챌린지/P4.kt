package 프로그래머스.월간코드챌린지

class P4 {
    fun solution(s: String): Long {
        var answer: Long = 0

        val map = HashMap<Range, CharArray>()

        fun search(start: Int, end: Int) {
            val chars = map.remove(Range(start, end - 1))!!
            val last = s[end]

            map[Range(start, end)] = chars.toMutableSet().apply { add(last) }.toCharArray()

            answer += if (chars.contains(last)) chars.size else chars.size + 1
        }

        0.until(s.length - 1).forEach {
            map[Range(it, it + 1)] = s.substring(it, it + 1).toCharArray()
        }


        3.until(s.length).forEach { num ->
            3.until(s.length).forEach { index ->
                search(index, index + num)
            }
        }

        return answer
    }

    data class Range(val start: Int, val end: Int)
}