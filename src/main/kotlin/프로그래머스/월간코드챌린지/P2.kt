package 프로그래머스.월간코드챌린지

fun main() {
    println(
        P2().solution(
            arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(1, 0, 0, 0),
                intArrayOf(1, 0, 0, 1),
                intArrayOf(1, 1, 1, 1)
            )
        ).joinToString()
    )
}

class P2 {
    companion object {
        private const val INVALID = -1
    }

    fun solution(arr: Array<IntArray>): IntArray {
        val answer = IntArray(2)

        fun search(arr: Array<IntArray>, sX: Int, sY: Int, eX: Int, eY: Int) {
            var tmp = INVALID
            var check = true

            (sX..eX).forEach { x ->
                (sY..eY).forEach { y ->
                    if (tmp == INVALID) tmp = arr[x][y]
                    else {
                        if (tmp != arr[x][y]) {
                            check = false
                            search(arr, sX, sY, eX - (eX - sX + 1) / 2, eY - (eY - sY + 1) / 2)
                            search(arr, sX, sY + (eY - sY + 1) / 2, eX - (eX - sX + 1) / 2, eY)
                            search(arr, sX + (eX - sX + 1) / 2, sY, eX, eY - (eY - sY + 1) / 2)
                            search(arr, sX + (eX - sX + 1) / 2, sY + (eY - sY + 1) / 2, eX, eY)
                        }
                    }
                    if (!check) return
                }
            }
            answer[tmp] = answer[tmp] + 1
        }

        search(arr, 0, 0, arr.size - 1, arr[0].size - 1)

        return answer
    }
}