class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freqs = IntArray(26)
        var mostFreq = 0

        var left = 0
        var right = 0
        var longest = 0

        while (right < s.length) {
            val char = s[right] - 'A'
            freqs[char]++

            if (freqs[char] > mostFreq) {
                mostFreq = freqs[char]
            }

            while (right - left + 1 - mostFreq > k) {
                val prev = s[left] - 'A'
                freqs[prev]--
                if (prev == char) mostFreq--
                left++
            }

            longest = maxOf(longest, right - left + 1)
            right++
        }

        return longest
    }
}
