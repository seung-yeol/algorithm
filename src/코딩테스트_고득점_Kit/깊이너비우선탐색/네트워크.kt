package 코딩테스트_고득점_Kit.깊이너비우선탐색

class 네트워크 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var score = 1
        var start: Boolean

        fun search(aIndex: Int) {
            computers[aIndex].let { intArray ->
                intArray.forEachIndexed { bIndex, value ->
                    if (value > 1) {
                        return@forEachIndexed
                    } else if (value == 1) {
                        intArray[bIndex] = score
                        if (aIndex != bIndex){
                            search(bIndex)
                        }
                    }
                }
            }
        }

        computers.forEachIndexed outSide@{ aIndex, intArray ->
            start = true
            intArray.forEachIndexed { bIndex, value ->
                if (value > 1) {
                    return@outSide
                } else if (value == 1) {
                    if(start){
                        score++
                        start = false
                    }

                    intArray[bIndex] = score
                    if ( aIndex != bIndex){
                        search(bIndex)
                    }
                }
            }
        }

        return score - 1
    }
}