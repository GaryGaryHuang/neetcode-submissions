class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        //  <Index, Temp>
        val arrayDeque = ArrayDeque<Pair<Int, Int>>()
        val res = IntArray(temperatures.size)
        for (i in 0 until temperatures.size) {
            val current = temperatures[i]
            while (arrayDeque.isNotEmpty() && arrayDeque.last().second < current) {
                val (last, lastT) = arrayDeque.removeLast()
                res[last] = i - last
            }
            arrayDeque.addLast(Pair(i, current))
        }
        return res
    }
}

/**
Push the index and temperature onto a stack. 
If a new temperature is higher than the top element, pop it, update the result, 
and then push the new index and temperature.
*/
