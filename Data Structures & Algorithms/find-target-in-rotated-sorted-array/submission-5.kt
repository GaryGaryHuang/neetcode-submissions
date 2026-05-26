class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                target == nums[mid] -> return mid
                nums[left] <= nums[mid] -> {
                    if (target in nums[left]..nums[mid]) right = mid - 1
                    else left = mid + 1
                }
                else -> {
                    if (nums[mid] < target && target <= nums[right]) left = mid + 1
                    else right = mid - 1
                }
            }
        }
        return -1
    }
}
