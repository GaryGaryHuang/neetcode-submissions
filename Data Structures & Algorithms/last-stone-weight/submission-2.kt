class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(reverseOrder())
        for (s in stones) {
            pq.offer(s)
        }

        while (pq.size > 1) {
            val x = pq.poll()
            val y = pq.poll()
            if (x != y) {
                pq.offer(x - y)
            }
        }
        return if (pq.isEmpty()) 0 else pq.peek()
    }
}
