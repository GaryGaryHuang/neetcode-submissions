class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] > nums[right]) left = mid + 1
            else right = mid
        }
        return nums[left]
    }
}

/**
If the element is kept ascending, the smallest element is at the first,
keep the beginning index at ther first.

If the mid index of value is bigger than the right index of value,
the smallest value is on the right hand side.

Otherwise, the smallest value is on the left hand side.
*/