class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val counts = IntArray(26)
        for (t in tasks) {
            counts[t - 'A']++
        }

        val pq = PriorityQueue<Int>(reverseOrder())
        for (c in counts) {
            if (c > 0) pq.offer(c)
        }

        var cycle = 0
        val cooler = ArrayDeque<Pair<Int, Int>>() // Pair<Time, Count>
        while (pq.isNotEmpty() || cooler.isNotEmpty()) {
            if (pq.isNotEmpty()) {
                val count = pq.poll()
                if (count > 1) cooler.add(Pair(cycle + n + 1, count - 1))                
            }
            cycle++
            while (cooler.isNotEmpty() && cycle >= cooler.peek().first) {
                val (_, count) = cooler.removeFirst()
                pq.offer(count)
            }
        }
        return cycle
    }
}
