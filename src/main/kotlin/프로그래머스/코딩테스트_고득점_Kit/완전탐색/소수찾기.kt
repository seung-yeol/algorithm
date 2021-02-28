package 프로그래머스.코딩테스트_고득점_Kit.완전탐색

import java.util.*
class 소수찾기 {
    fun solution(numbers: String): Int {
        val l = numbers.length
        val list = numbers.asIterable().sortedDescending()

        val max = numbers.indices.reduce { acc, i -> acc + Math.pow(l.toDouble(), i.toDouble()).toInt() * (l - 1)} + l - 1
        val trueL = HashSet<Int>()

        for (i in 0..max) {
            var k = i
            val gg = LinkedList<Int>()
            val tmpL = LinkedList<Char>()
            var tt = true
            do {
                val element = k % l
                if (!gg.contains(element)) {
                    gg.add(element)
                    tmpL.addFirst(list[element])
                } else {
                    tt = false
                    gg.clear()
                    tmpL.clear()
                    break
                }
                k /= l
            } while (k / l != 0)

            if (tt) {
                val element = k % l
                if (!gg.contains(element)) {
                    tmpL.addFirst(list[element])
                    gg.add(element)
                }
                trueL.add(tmpL.joinToString("").toInt())
                if (tmpL.size != l && !gg.contains(0)) trueL.add(tmpL.apply {addFirst(list[0])}.joinToString("").toInt())
            }
        }

        val primeNums = LinkedList<Int>().apply { add(2) }
        val sqrt = Math.sqrt(list.joinToString("").toDouble()).toInt()
        if (sqrt >= 3)
            (3..sqrt + 1 step 2).fold(primeNums) { acc, i -> acc.apply { if (none { i % it == 0 }) add(i) } }

        return trueL.apply { removeAll(arrayOf(0, 1)) }.fold(trueL.size) { acc, target ->
            if (primeNums.filter { Math.sqrt(target.toDouble()) >= it }.any { target % it == 0 }) acc - 1
            else acc
        }
    }
}