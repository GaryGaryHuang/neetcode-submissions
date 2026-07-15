class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val taskArray = IntArray(26)
        for (t in tasks) {
            taskArray[t - 'A']++
        }

        val pq = PriorityQueue<Task>(
            compareByDescending<Task> { it.count }
                .thenBy { it.nextCycle }
        )
        for (t in taskArray) {
            if (t > 0) pq.offer(Task(t))
        }

        var cycle = 0
        while (pq.isNotEmpty()) {
            if (cycle >= pq.peek().nextCycle) {
                val task = pq.poll()
                if (task.count > 1) {
                    pq.offer(Task(task.count - 1, cycle + n + 1))
                }
            }
            cycle++
        }
        return cycle
    }
}

data class Task(
    val count: Int,
    val nextCycle: Int = 0,
)
