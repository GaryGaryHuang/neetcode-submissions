class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) return mid
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        return -1
    }
}

/**
If an algorithm need to runs in O(log n) time, it may be binary search.

Check the mid index of value.
If the left part is a ascending order and the target is in this range,
move the right index to mid - 1.

If the right part is a ascending order and the target is in this range,
move the left index to mid + 1
*/
