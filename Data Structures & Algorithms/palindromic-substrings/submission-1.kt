class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in 0 until s.length) {
            // odd
            var l = i
            var r = i
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--
                r++
                count++
            }

            //  even
            l = i
            r = i + 1
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--
                r++
                count++
            }
        }
        return count
    }
}
