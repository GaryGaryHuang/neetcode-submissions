class Solution {
    fun dailyTemperatures(array: IntArray): IntArray {
        val res = IntArray(array.size)
        val arrayDeque = ArrayDeque<Int>()
        for (i in 0 until array.size) {
            while (arrayDeque.isNotEmpty() && array[i] > array[arrayDeque.last()]) {
                val last = arrayDeque.removeLast()
                res[last] = i - last
            }
            arrayDeque.addLast(i)
        } 
        return res
    }
}

/**
 * The stack stores indices of days that are still waiting for a warmer future day.
 * When the current day is warmer than the day at the top of the stack,
 * pop that index and use the current index to calculate the waiting days.
 */
