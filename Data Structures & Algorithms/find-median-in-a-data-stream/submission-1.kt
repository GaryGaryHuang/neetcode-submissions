class MedianFinder {
    private val left = PriorityQueue<Int>(reverseOrder())
    private val right = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (left.isEmpty() || num < left.peek()) left.offer(num)
        else right.offer(num)

        while (right.size > left.size) left.offer(right.poll())
        while (left.size - 1 > right.size) right.offer(left.poll())
    }

    fun findMedian(): Double {
        return if (left.size == right.size) ((left.peek() + right.peek()) / 2.0)
        else left.peek().toDouble()
    }
}

/**
[] x [] -> odd number of items, answer is x.
[] [] -> even number of items, 
answer is ((the last item on the left) + (the first item on the right)) / 2.

Use two heaps: the left side is a max heap and the right side is a min heap.
*/
