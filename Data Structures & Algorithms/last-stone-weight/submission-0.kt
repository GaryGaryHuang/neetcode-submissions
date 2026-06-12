class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        for (s in stones) {
            maxHeap.offer(s)
        }

        while (maxHeap.size > 1) {
            val x = maxHeap.poll()
            val y = maxHeap.poll()
            if (x != y) {
                maxHeap.offer(x - y)
            }
        }

        return if (maxHeap.isEmpty()) 0 else maxHeap.peek()
    }
}
