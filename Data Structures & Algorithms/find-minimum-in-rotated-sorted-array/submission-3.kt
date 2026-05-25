class Solution {
    fun findMin(nums: IntArray): Int {
        var res = nums[0]
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            if (nums[mid] > nums.last()) {
                l = mid + 1
            } else {
                r = mid - 1
                res = minOf(res, nums[mid])
            }
        }
        return res
    }
}
