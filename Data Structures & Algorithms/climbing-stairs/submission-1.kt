class Solution {
    fun climbStairs(n: Int): Int {
        val array = IntArray(n + 1)
        array[0] = 1
        array[1] = 1
        for (i in 2..n) {
            array[i] = array[i - 1] + array[i - 2]
        }
        return array[n]
    }
}

/**
At each step, I can take either 1 or 2 steps.
There is only one way to reach steps 0 and 1.
However, step 2 can be reached from either step 0 or step 1.
Therefore, array[0] = 1, array[1] = 1, and array[2] = array[0] + array[1].
*/
