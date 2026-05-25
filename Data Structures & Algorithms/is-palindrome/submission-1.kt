class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (!(isAlphabet(s[left]))) {
                left++
                continue
            }
            if (!isAlphabet(s[right])) {
                right--
                continue
            }
            if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false
            left++
            right--
        }
        return true
    }

    private fun isAlphabet(c: Char): Boolean {
        if (c - 'a' in 0..25) return true
        if (c - 'A' in 0..25) return true
        if (c - '0' in 0..9) return true
        return false
    }
}
