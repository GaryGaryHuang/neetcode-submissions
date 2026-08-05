class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val array = IntArray(cost.size)
        array[0] = cost[0]
        array[1] = cost[1]
        for (i in 2 until cost.size) {
            array[i] = minOf(array[i - 1], array[i - 2]) + cost[i]
        }
        return minOf(array[array.size - 1], array[array.size - 2])
    }
}

/**
I can start at either index 0 or 1, with a cost of array[0] or array[1]. 
After that, I can move forward by one or two steps. 
At each step, I choose the smaller cost from the previous one or two steps.
*/
