class KthLargest(private val k: Int, nums: IntArray) {
    val pq = PriorityQueue<Int>()

    init {
        for (num in nums) {
            pq.offer(num)
            if (pq.size > k) pq.poll()
        }
    }

    fun add(`val`: Int): Int {
        pq.offer(`val`)
        if (pq.size > k) pq.poll()
        return pq.peek()
    }
}
