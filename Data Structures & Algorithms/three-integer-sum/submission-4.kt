class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        for (i in 0 until nums.size) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum > 0 -> right--
                    sum < 0 -> left++
                    else -> {
                        res.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--
                        while (left < right && nums[left] == nums[left - 1]) left++
                    }
                }
            }
        }
        return res
    }
}
