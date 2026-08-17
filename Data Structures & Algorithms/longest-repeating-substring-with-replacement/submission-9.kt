class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val count = mutableMapOf<Char, Int>()

        var res = 0
        var left = 0
        var right = 0
        var freqChar = s[0]
        while (right < s.length) {
            val char = s[right]
            count[char] = (count[char] ?: 0) + 1
            right++

            val freqCharCount = count[freqChar]!!
            if (right - left - freqCharCount <= k) {
                res = maxOf(res, right - left)
                continue
            }

            count[s[left]] = count[s[left]]!! - 1
            left++

            val currentCharCount = count[char]!!
            if (currentCharCount > freqCharCount) freqChar = char
        }
        return res
    }
}
