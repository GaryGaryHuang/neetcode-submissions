class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freq = IntArray(26)
        var longest = 0

        var left = 0
        var right = 0
        var base = s[0] - 'A'
        while (right < s.length) {
            val cur = s[right] - 'A'
            freq[cur]++

            while (freq[base] + k < (right - left + 1)) {
                val last = s[left] - 'A'
                freq[last]--
                left++
            }

            if (freq[cur] > freq[base]) {
                base = cur
            }

            longest = maxOf(longest, right - left + 1)
            right++
        }

        return longest
    }
}
