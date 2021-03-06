package 프로그래머스.코딩테스트_고득점_Kit.깊이너비우선탐색

class 타겟넘버 {
    private lateinit var states: IntArray
    private var answer = 0
    private var target = 0
    private var result = 0
    private var nSize = 0
    private var end = false
    private var position = 0

    fun solution(numbers: IntArray, target: Int): Int {
        this@타겟넘버.target = target

        nSize = numbers.size
        states = IntArray(numbers.size)

        while(!end){
            check(numbers)
        }

        return answer
    }

    fun plus(numbers: IntArray) {
        states[position] = 1
        result += numbers[position]
        position++
    }

    fun minus(numbers: IntArray) {
        states[position] = -1
        result -= numbers[position]
        position++
    }

    fun up(numbers: IntArray) {
        if (position == 0) {
            end = true
            return
        }

        position--

        val state = states[position]
        result -= state * numbers[position]
        states[position] = 0

        when (state) {
            1 -> minus(numbers)
            -1 -> up(numbers)
        }
    }

    fun check(numbers: IntArray) {
        if (numbers.size == position) {
            if (result == target) {
                answer++
            }
            up(numbers)
        } else {
            val state = states[position]
            when (state) {
                1 -> up(numbers)
                0 -> plus(numbers)
                -1 -> up(numbers)
            }
        }
    }
}