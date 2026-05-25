class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var maxLen = 0
        for (num in set) {
            if ((num - 1) in set) continue

            var cur = num + 1
            while (cur in set) cur++
            maxLen = maxOf(maxLen, cur - num)
        }
        return maxLen
    }
}
