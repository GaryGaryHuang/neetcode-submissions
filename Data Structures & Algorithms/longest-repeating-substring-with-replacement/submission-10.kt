class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val counts = mutableMapOf<Char, Int>()
        
        var res = 0
        var left = 0
        var right = 0
        var maxFreq = 0
        while (right < s.length) {
            val char = s[right]
            counts[char] = (counts[char] ?: 0) + 1
            maxFreq = maxOf(maxFreq, counts[char] ?: 0)
            right++

            val repalcement = right - left - maxFreq
            if (repalcement > k) {
                val leftChar = s[left]
                counts[leftChar] = counts[leftChar]!! - 1
                left++
            }

            res = maxOf(res, right - left)
        }
        return res
    }
}
