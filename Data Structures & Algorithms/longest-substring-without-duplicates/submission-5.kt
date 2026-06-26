class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var maxLen = 0

        var left = 0
        var right = 0
        while (right < s.length) {
            while (s[right] in set) {
                set.remove(s[left])
                left++
            }
            set.add(s[right])
            maxLen = maxOf(maxLen, set.size)
            right++
        }

        return maxLen
    }
}
