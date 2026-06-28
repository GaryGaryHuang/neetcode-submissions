class Solution {
    fun dailyTemperatures(t: IntArray): IntArray {
        val res = IntArray(t.size)
        val deque = ArrayDeque<Int>()
        for (i in 0 until t.size) {
            while (deque.isNotEmpty() && t[i] > t[deque.last()]) {
                val prev = deque.removeLast()
                res[prev] = i - prev
            }
            deque.addLast(i)
        }
        return res
    }
}
