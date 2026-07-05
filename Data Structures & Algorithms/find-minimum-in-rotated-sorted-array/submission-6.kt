class Solution {
    fun findMin(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            if (nums[left] < nums[right]) {
                min = minOf(min, nums[left])
                break
            }

            val mid = (left + right) / 2
            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                min = minOf(min, nums[mid])
                right = mid - 1
            }
        }
        return min
    }
}


/**
non-rotated: [1, 2, 3, 4, 5]
rotated:
[2, 3, 4, 5, 6, 1]
[3, 4, 5, 6, 1, 2]
[4, 5, 6, 1, 2, 3]
[5, 6, 1, 2, 3, 4]
[6, 1, 2, 3, 4, 5]
O(log n) time -> tell me using binary search
I have left, mid, and right nums.
If the nums is sorted, left < mid < right.
The minimum is at the left side.

If the nums is rotated, there are many cases
left < mid, mid > right -> the minimun is at the right side
left > mid, mid < right -> the minimun is at the left side.
*/
