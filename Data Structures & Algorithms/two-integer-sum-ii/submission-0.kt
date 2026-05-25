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
            if (left == right) right = nums.lastIndex
        }
        return intArrayOf()
    }
}

//  I would use two pointer, which start at index first index and last index.
//  If their sum are greater than target, I move the right pointer to its previous one.
//  If their sum are smaller thant target, I move the left pointer to its later one.
//  Because the question says there must be one valid solution.
//  If the right pointer is equals to the left pointer, 
//  I will reset the right pointer to the last index again.
