class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var maxLen = 0
        var l = 0
        for (r in 0 until s.length) {
            while (s[r] in set) {
                set.remove(s[l])
                l++
            }
            set.add(s[r])
            maxLen = maxOf(maxLen, r - l + 1)
        }
        return maxLen
    }
}
