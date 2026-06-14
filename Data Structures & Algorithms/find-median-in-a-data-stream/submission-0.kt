class MedianFinder {
    private val maxHeap = PriorityQueue<Int>(reverseOrder()) // left
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) maxHeap.add(num)
        else minHeap.add(num)

        while (minHeap.size > maxHeap.size) maxHeap.add(minHeap.poll());
        while (maxHeap.size - minHeap.size > 1) minHeap.add(maxHeap.poll());
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) maxHeap.peek().toDouble()
        else (maxHeap.peek() + minHeap.peek()) / 2.0
    }
}

/**
[] x [] -> odd number of items, answer is x.
[] [] -> even number of items, 
answer is ((the last item on the left) + (the first item on the right)) / 2.

Use two heaps: the left side is a max heap and the right side is a min heap.
*/
