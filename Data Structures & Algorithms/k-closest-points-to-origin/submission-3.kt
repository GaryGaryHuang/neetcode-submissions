class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<Pair<Int, IntArray>>(compareByDescending { it.first })
        for (p in points) {
            val distance = p[0] * p[0] + p[1] * p[1]
            pq.offer(Pair(distance, p))
            if (pq.size > k) pq.poll()
        }

        val targetDistance = pq.peek().first
        val res = mutableListOf<IntArray>()
        while (pq.isNotEmpty() && pq.peek().first == targetDistance) {
            res.add(pq.poll().second)
        }
        return res.toTypedArray()
    }
}
