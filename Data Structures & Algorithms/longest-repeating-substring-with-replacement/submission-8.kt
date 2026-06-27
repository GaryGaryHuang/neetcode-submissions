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

            mostFreq = maxOf(mostFreq, freqs[char])

            while (right - left + 1 - mostFreq > k) {
                freqs[s[left] - 'A']--
                left++
            }

            longest = maxOf(longest, right - left + 1)
            right++
        }

        return longest
    }
}
