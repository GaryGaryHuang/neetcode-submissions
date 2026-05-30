class Solution {
    fun findMin(nums: IntArray): Int {
        var smallest = nums[0]

        var left = 0
        var right = nums.size - 1
    
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                smallest = nums[left]
                break
            }
            
            if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
                smallest = nums[mid]
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return smallest
    }
}

/**
xxx ? yyy

if x < y, it means the subarray is no rotated.
the smallest num is on the most left hand side.

if x > y,

- ? < x && ? < y, it means the smallest num is on the left hand side.
- otherwise, it means the smallest num is on the right hand side.
*/
