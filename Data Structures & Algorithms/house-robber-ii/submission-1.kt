class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])

        val dp1 = IntArray(nums.size - 1)
        dp1[0] = nums[0]
        dp1[1] = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size - 1) {
            dp1[i] = maxOf(dp1[i - 2] + nums[i], dp1[i - 1])
        }

        val dp2 = IntArray(nums.size)
        dp2[0] = 0
        dp2[1] = nums[1]
        for (i in 2 until nums.size) {
            dp2[i] = maxOf(dp2[i - 2] + nums[i], dp2[i - 1])
        }

        return maxOf(dp1.last(), dp2.last())
    }
}

/**
1. Steal the first and do not steal the last
2. Do not steal the first
*/
