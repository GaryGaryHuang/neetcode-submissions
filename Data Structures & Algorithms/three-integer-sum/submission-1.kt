class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val set = mutableSetOf<List<Int>>()
        for (i in 0 until nums.size) {
            if (nums[i] > 0) break

            val target = -nums[i]
            var j = i + 1
            var k = nums.lastIndex
            while (j < k) {
                val sum = nums[j] + nums[k]
                when {
                    sum == target -> {
                        set.add(listOf(nums[i], nums[j], nums[k]))
                        j++
                    }
                    sum > target -> k--
                    else -> j++
                }
            }
        }
        return set.toList()
    }
}
