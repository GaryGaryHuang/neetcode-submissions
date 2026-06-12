class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        //  index, distance
        val minHeap = PriorityQueue<Pair<Int, Double>>(compareBy { it.second })
        for (i in 0 until points.size) {
            val (x, y) = points[i]
            val distance = Math.sqrt(x.toDouble() * x + y.toDouble() * y)
            minHeap.add(Pair(i, distance))
        }

        val array = Array<IntArray>(k) { IntArray(2) }
        repeat(k) { times ->
            val (i, _) = minHeap.poll()
            val (x, y) = points[i]
            array[times][0] = x
            array[times][1] = y
        }
        return array
    }
}
