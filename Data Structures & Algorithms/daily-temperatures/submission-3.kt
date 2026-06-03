class Solution {
    fun dailyTemperatures(temps: IntArray): IntArray {
        val arrayDeque = ArrayDeque<Int>()
        val res = IntArray(temps.size)
        for (i in 0 until temps.size) {
            val temp = temps[i]
            while (arrayDeque.isNotEmpty() && temp > temps[arrayDeque.last()]) {
                val prev = arrayDeque.removeLast()
                res[prev] = i - prev
            }
            arrayDeque.add(i)
        }
        return res
    }
}

/**
Push every temp onto Stack.
Before pushing it, pop any temp smaller than the current one.
Because we need to output the day diff, we also need to store the temp's index.
*/
