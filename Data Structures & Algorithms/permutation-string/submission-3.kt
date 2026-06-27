class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val freq1 = IntArray(26)
        for (c in s1) {
            freq1[c - 'a']++
        }
        val key1 = freq1.joinToString()

        val freq2 = IntArray(26)
        var left = 0
        for (right in 0 until s2.length) {
            freq2[s2[right] - 'a']++
            if (right - left + 1 > s1.length) {
                freq2[s2[left] - 'a']--
                left++
            }
            if (right - left + 1 == s1.length && key1 == freq2.joinToString()) {
                return true
            }
        }
        return false
    }
}
