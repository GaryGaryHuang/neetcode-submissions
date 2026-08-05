class Solution {
    fun longestPalindrome(s: String): String {
        var res = ""
        for (i in 0 until s.length) {
            var width = 0
            while (
                i - width >= 0 
                && i + width < s.length 
                && s[i - width] == s[i + width]
            ) {
                if (2 * width + 1 > res.length) {
                    res = s.substring(i - width, i + width + 1)
                }
                width++
            }
        }

        for (i in 1 until s.length) {
            var width = 0
            while (
                s[i] == s[i - 1] 
                && i - 1 - width >= 0
                && i + width < s.length
                && s[i - 1 - width] == s[i + width]
            ) {
                if (2 * width + 2 > res.length) {
                    res = s.substring(i - 1 - width, i + width + 1)
                }
                width++
            }
        }

        return res
    }
}
