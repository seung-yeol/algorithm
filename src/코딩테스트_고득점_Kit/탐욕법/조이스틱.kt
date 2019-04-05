package 코딩테스트_고득점_Kit.탐욕법

class 조이스틱 {
    fun solution(name: String): Int {
        val size = name.length
        var answer = 0

        //-------------------------------
        //일단 무식하게 앞에서부터 다 해버리고
        val array = name.chars().toArray()
        array.forEach {
            val value = it - 'A'.toInt()
            answer += if (value <= 13) value
            else 'Z'.toInt() - it + 1
        }
        answer += size - 1
        //-------------------------------
        //그 후 A인 곳 중 갈 필요 없는 곳 거를거임

        //    v-----v
        // B ABAAAAABB
        // 0 123456789
        //    ^-----^

        //A가 아닌 처음 포지션 0번째 제외
        //주석 그림을 보면 first = 2
        var first = -1

        //A가 아닌 마지막 포지션
        //주석 그림을 보면 last = 9
        var last = -1

        //주석 그림을 보면 fl = 2
        var fl = -1
        //주석 그림을 보면 lf = 8
        var lf = -1

        //A가 연속되는 최대 count 주석그림에 ----- 되있는 갯수 즉 count = 5
        var count = 0
        var tmp = 0

        array.forEachIndexed { index, value ->
            if (index != 0){
                if (value != 'A'.toInt() ) {
                    if (count < tmp) {
                        count = tmp
                        tmp = 0
                        fl = index - count - 1
                        lf = index
                    }
                    if (first == -1) {
                        first = index
                    }
                    last = index
                } else {
                    tmp++
                }
            }
        }

        if (size - lf + first < count || fl - 1  + size - last < count && count != 0) {
            answer -= count
            answer += if (first == lf) {
                //뒤에서 순서대로          ex) BAAAAAAABBBBB or AAAAAABBBBBBBBBB
                var c = 0
                for (i in 1 until size) {
                    if (array[i] != 'A'.toInt()) {
                        c++
                    } else {
                        break
                    }
                }
                -c
            } else if (fl > size - lf) {
                //뒤 먼저 갔다가 다시 앞으로 ex) BBBBBAAAAAAAAAABB
                size - lf
            } else {
                //앞 먼저 갔다가 다시 뒤    ex) BBAAAAAAAAABBBBBB
                fl
            }
        } else {
            //앞에서 순서대로              ex) BBBBBBBBAABBAAAAA
            var c = 0
                for (i in size - 1 downTo 0) {
                if (array[i] == 'A'.toInt()) {
                    c++
                } else {
                    answer -= c
                    break
                }
            }

        }

        return answer
    }
}