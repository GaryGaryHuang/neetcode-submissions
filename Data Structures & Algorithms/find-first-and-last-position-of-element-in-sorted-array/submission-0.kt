class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val res = intArrayOf(-1, -1)

        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) left = mid + 1
            else if (nums[mid] > target) right = mid - 1
            else {
                res[0] = mid
                right = mid - 1
            }
        }

        left = 0
        right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) left = mid + 1
            else if (nums[mid] > target) right = mid - 1
            else {
                res[1] = mid
                left = mid + 1
            }
        }

        return res
    }
}
