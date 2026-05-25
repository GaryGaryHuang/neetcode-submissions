class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val list = mutableListOf<List<Int>>()
        for (i in 0 until nums.size) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue 

            val target = -nums[i]
            var j = i + 1
            var k = nums.lastIndex
            while (j < k) {
                val sum = nums[j] + nums[k]
                when {
                    sum == target -> {
                        list.add(listOf(nums[i], nums[j], nums[k]))
                        j++
                        k--
                        while (j < k && nums[j] == nums[j - 1]) j++
                        while (j < k && nums[k] == nums[k + 1]) k--
                    }
                    sum > target -> k--
                    else -> j++
                }
            }
        }
        return list
    }
}
