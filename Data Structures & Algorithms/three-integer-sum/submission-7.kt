class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        for (i in 0 until nums.size) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                when {
                    sum == 0 -> {
                        res.add(listOf(nums[i], nums[j], nums[k]))

                        var nextJ = j + 1
                        while (nextJ < k && nums[j] == nums[nextJ]) nextJ++
                        j = nextJ
                    }
                    sum > 0 -> k--
                    else -> j++
                }
            }
        }
        return res
    }
}
