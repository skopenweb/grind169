package week2

import prettyPrint
import java.util.*

class P01Matrix {

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val visited = Array(mat.size) { BooleanArray(mat[0].size)}
        val distance = Array(mat.size) { IntArray(mat[0].size) }

        val queue = LinkedList<Pair<Int, Int>>()

        for (i in mat.indices) {
            for (j in mat[0].indices) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true
                    distance[i][j] = 0
                    queue.add(Pair(i, j))
                }
            }
        }
        while (queue.isNotEmpty()) {
            val point = queue.poll()
            val x = point.first
            val y = point.second
            val dist = distance[x][y]

            for (i in -1..1) {
                for (j in -1..1) {
                    if (Math.abs(i + j) == 1 &&
                        x + i in 0..<mat.size &&
                        y + j in 0..<mat[0].size &&
                        visited[x + i][y + j].not()
                    ) {
                        visited[x + i][y + j] = true
                        distance[x+i][y+j] = dist + 1
                        queue.offer(Pair(x+i, y+j))
                    }
                }
            }


        }

        return distance
    }
}

fun main() {
    val result = P01Matrix().updateMatrix(
        arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
    )
    result.prettyPrint()
}