class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for (n in nums) {
            if (!set.add(n)) {
                return true
            }
        }
        return false
    }
}

// A set can check whether there are two identical items by the `add` fucntion.
// If the fun returns true, it means this is a new item; otherwise it's duplicate.

// steps:
// 1. check every item in a loop
// 2. If I find a duplicate item, then return true
// 3. Finally, if I don't find any duplicate item, then return false