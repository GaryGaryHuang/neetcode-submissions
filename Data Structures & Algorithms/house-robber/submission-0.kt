class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size) {
            dp[i] = maxOf(dp[i - 2] + nums[i], dp[i - 1])
        }
        return dp.last()
    }
}

/**
1 2 3 4
The robber can steal the first or the second.
If the robber steals the first, and then he can steal the third.
If the robber steals the second, and then he can steal the fourth.
If the rubber want to steal the current, then he cannot steal the prervious one.
*/
