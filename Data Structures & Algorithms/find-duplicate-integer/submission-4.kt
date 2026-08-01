class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[nums[0]]

        while (slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }

        var entry = 0
        while (entry != slow) {
            entry = nums[entry]
            slow = nums[slow]
        }

        return entry
    }
}
