class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freq = IntArray(26)
        var longest = 0

        var left = 0
        var right = 0
        var base = s[0] - 'A'
        while (right < s.length) {
            freq[s[right] - 'A']++

            while (right - left + 1 - freq[base] > k) {
                freq[s[left] - 'A']--
                left++

                if (freq[s[right] - 'A'] >= freq[base]) {
                    base = s[right] - 'A'
                }
            }

            longest = maxOf(longest, right - left + 1)
            right++
        }

        return longest
    }
}
