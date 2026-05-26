class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            println("$left, $right")
            val mid = (left + right) / 2
            when {
                target == nums[mid] -> return mid
                target < nums[mid] -> {
                    if (target < nums[left]) left = mid + 1
                    else right = mid - 1
                }
                else -> {
                    // target > nums[mid]
                    if (target > nums[right]) right = mid - 1
                    else left = mid + 1
                }
            }
        }
        return -1
    }
}
