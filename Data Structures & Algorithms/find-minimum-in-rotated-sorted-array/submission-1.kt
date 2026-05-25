class Solution {
    fun findMin(nums: IntArray): Int {
        var res = 1001
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            val num = nums[mid]
            when {
                num >= nums.first() && num <= nums.last() -> r = mid - 1
                num <= nums.first() && num <= nums.last() -> r = mid - 1
                num >= nums.first() && num >= nums.last() -> l = mid + 1
                num <= nums.first() && num >= nums.last() -> l = mid + 1
            }
            res = minOf(res, num)
        }
        return res
    }
}

/**
1 6
6 5
5 4
4 3
3 2
2 1

ascending   ascending
_________ x _________
If x >= the start && x <= the end, this means the target is in this interval.
If x <= the start && x <= the end, this means the target is in this interval.
If x >= the start && x >= the end, this means the target is on the right side.
If x <= the start && x >= the end, this means the target is on the right side.
*/
