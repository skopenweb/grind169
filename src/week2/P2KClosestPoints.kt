package week2

import java.util.*

class P2KClosestPoints {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray>(k + 1) { p1, p2 ->
            val d1 = p1[0] * p1[0] + p1[1] * p1[1]
            val d2 = p2[0] * p2[0] + p2[1] * p2[1]
            d2 - d1
        }

        for (p in points) {
            pq.offer(p)
            if (pq.size > k) {
                pq.poll()
            }
        }
        return Array(k) {
            val p = pq.poll()
            intArrayOf(p[0], p[1])
        }
    }
}