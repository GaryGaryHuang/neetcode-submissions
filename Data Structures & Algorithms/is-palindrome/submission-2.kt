class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (!isAlphanumeric(s[left])) {
                left++
                continue
            }
            if (!isAlphanumeric(s[right])) {
                right--
                continue
            }
            if (s[left].lowercase() != s[right].lowercase()) return false
            left++
            right--
        }
        return true
    }

    private fun isAlphanumeric(c: Char): Boolean {
        return c in 'a'..'z' || c in 'A'..'Z' || c in '0'..'9'
    }
}
