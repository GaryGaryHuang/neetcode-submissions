class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // If the answer is exactly one, I can save the number's diff into a map.
        //  When a new number is coming, I can check it at first.
        val map = mutableMapOf<Int, Int>() // num, index
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (num in map) {
                return intArrayOf(map[num]!!, i)
            }
            map[target - num] = i
        }
        return intArrayOf()
    }
}
