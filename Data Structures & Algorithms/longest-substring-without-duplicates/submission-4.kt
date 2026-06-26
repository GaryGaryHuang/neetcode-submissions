class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLen = 0
        var cToPrev = mutableMapOf<Char, Int>()

        var start = 0
        for (i in 0 until s.length) {
            val prev = cToPrev[s[i]] ?: -1
            if (prev >= start) {
                maxLen = maxOf(maxLen, i - start)
                start = i
            }
            cToPrev[s[i]] = i
        }
        maxLen = maxOf(maxLen, s.length - start)
        return maxLen
    }
}
