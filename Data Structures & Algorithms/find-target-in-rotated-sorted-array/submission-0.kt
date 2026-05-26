class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                else -> {
                    //  nums[mid] > target
                    if (target >= nums[0]) right = mid - 1
                    else left = mid + 1
                }
            }
        }
        return -1
    }
}
