class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            // check items
            if (!set.add(num)) {
                return true
            }
        }
        return false
    }
}

// In this problem, I’d use a set: if set.add() returns true, there are no duplicates; otherwise, duplicates exist.
// Time complexity is O(n)