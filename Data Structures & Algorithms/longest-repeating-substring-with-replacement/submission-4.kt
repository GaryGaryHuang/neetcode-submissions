class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var maxLength = 0

        val counts = IntArray(26)
        var maxFreq = 0
        var l = 0
        for (r in 0 until s.length) {
            val charIndex = s[r] - 'A'
            counts[charIndex]++
            maxFreq = maxOf(maxFreq, counts[charIndex])
            
            while (r - l + 1 - maxFreq > k) {
                counts[s[l] - 'A']--
                l++
            }

            maxLength = maxOf(maxLength, r - l + 1)
        }
        return maxLength
    }
}

/**
Count the frequency of each char, 
then choose the most frequent char as the target, 
since it requires the fewest replacements.
*/
