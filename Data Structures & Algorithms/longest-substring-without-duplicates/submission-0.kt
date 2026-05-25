class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastSeen = mutableMapOf<Char, Int>()
        var maxLength = 0
        var left = 0
        var right = 0
        while (right < s.length) {
            val char = s[right]
            lastSeen[char]?.takeIf{ it >= left }?.run {
                left = lastSeen[char]!! + 1
            }

            lastSeen[char] = right
            maxLength = maxOf(maxLength, right - left + 1)
            right++
        }
        return maxLength
    }
}

/**
I need to find the longest substring with all unique characters.
I may need a set to check for duplicate characters
as well as an map to record the last-seen index of each character.

If I see a duplicate character, 
I move the left pointer to the position after its last occurrence.
**/
