class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in 0 until s.length) {
            var l = i
            var r = i
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                count++
                l--
                r++
            }

            l = i
            r = i + 1
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                count++
                l--
                r++
            }           
        }
        return count
    }
}
