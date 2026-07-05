class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) return mid
            if (nums[left] <= nums[mid]) {
                if (target in nums[left]..nums[mid]) {
                    right = mid
                } else {
                    left = mid + 1
                }
            } else {
                if (target in nums[mid]..nums[right]) {
                    left = mid
                } else {
                    right = mid - 1
                }
            }
        } 
        return -1
    }
}

/**
sorted: [1, 2, 3, 4, 5]
rotated:
[2, 3, 4, 5, 6, 1]
[3, 4, 5, 6, 1, 2]
[4, 5, 6, 1, 2, 3]
[5, 6, 1, 2, 3, 4]
[6, 1, 2, 3, 4, 5]

I can only search target in sorted array.
If left part is sorted, there are two cases:
- target >= left && target <= mid -> right = mid
- otherwise, left = mid + 1

If right part is sorted, there are also two cases:
- target >= mid && target <= right -> left = mid
- otherwise, left = mid - 1
*/