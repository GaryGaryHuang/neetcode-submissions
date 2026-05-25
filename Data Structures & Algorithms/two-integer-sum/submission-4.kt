class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val x = nums[i]
            val y = target - x
            if (y in map) return intArrayOf(map[y]!!, i)
            else map[x] = i
        }
        return intArrayOf()
    }
}
