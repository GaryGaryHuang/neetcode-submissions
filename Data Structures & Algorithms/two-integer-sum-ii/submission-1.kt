class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.lastIndex
        while (left < right) {
            val sum = nums[left] + nums[right]
            when {
                sum == target -> return intArrayOf(left + 1, right + 1)
                sum > target -> right--
                else -> left++
            }
        }
        return intArrayOf()
    }
}

/**
Use two pointers, one at the beginning and one at the end of the sorted array.
If their sum is greater than the target, move the right pointer left to reduce the sum.
If their sum is smaller than the target, move the left pointer right to increase the sum.
Each pointer moves at most n times, so the time complexity is O(n) and the extra space is O(1).
**/
