class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val pairMap = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (num in pairMap) {
                return intArrayOf(pairMap[num]!!, i)
            } else {
                pairMap[target - num] = i
            }
        }
        return intArrayOf()
    }
}
