class Solution {
    fun climbStairs(n: Int): Int {
        val ways = IntArray(n + 1)
        ways[0] = 1
        ways[1] = 1
        for (i in 2..n) {
            ways[i] = ways[i - 1] + ways[i - 2]
        }
        return ways[n]
    }
}

/**
0 1 2 3
I start at 0.
To index 1, there is only one way from 0 to 1.
To index 2, there are two ways: one is from 1 to 2, and the other is from 0 to 2.
To index 3, there are also two ways: one is from 2 to 3, and the other is from 1 to 3.
*/
