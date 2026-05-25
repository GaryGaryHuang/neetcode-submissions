class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableSetOf<List<Int>>()
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    if (nums[i] + nums[j] + nums[k] == 0) res.add(listOf(nums[i], nums[j], nums[k]))
                }
            }
        }
        return res.toList()
    }
}
