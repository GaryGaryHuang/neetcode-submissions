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

        val ttl = ArrayDeque<Pair<Int, Int>>() // Pair<time, count>
        var cycle = 0
        while (pq.isNotEmpty() || ttl.isNotEmpty()) {
            if (pq.isNotEmpty()) {
                val count = pq.poll()
                if (count > 1) ttl.add(Pair(cycle + n + 1, count - 1))
            }
            cycle++
            while (ttl.isNotEmpty() && cycle >= ttl.first().first) {
                val count = ttl.removeFirst().second
                pq.add(count)
            }
        }
        return cycle
    }
}
