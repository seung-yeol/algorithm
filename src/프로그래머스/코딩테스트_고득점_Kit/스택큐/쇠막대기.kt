package 프로그래머스.코딩테스트_고득점_Kit.스택큐

fun main(args : Array<String>){
    println(쇠막대기().solution("()(((()())(())()))(())"))
}
class 쇠막대기 {
    fun solution(arrangement: String): Int {
        var answer = 0
        var count = 0

        arrangement.fold(' ') { aac, char ->
            if (aac == '(') {
                if (char == '(') count++
                else answer += --count
            } else {
                if (char == '(') count++
                else{
                    count--
                    answer++
                }
            }
            char
        }

        return answer
    }
}