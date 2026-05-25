class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        for (i in 0 until nums.size) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            for (j in i + 1 until nums.size) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) continue
                for (k in j + 1 until nums.size) {
                    val sum = nums[i] + nums[j] + nums[k]
                    if (sum > 0) break
                    if (sum == 0) {
                        res.add(listOf(nums[i], nums[j], nums[k]))
                        break
                    }
                }
            }
        }
        return res
    }
}
