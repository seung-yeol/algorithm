package 코딩테스트_고득점_Kit.완전탐색

class 카펫 {
    fun solution(brown: Int, red: Int): IntArray {
        var answer = intArrayOf()

        for (i in 1..red) {
            if (red % i == 0 && (((red / i) + i + 2) * 2) == brown) {
                answer = intArrayOf(i + 2, red / i + 2)
            }
        }

        return answer
    }
}