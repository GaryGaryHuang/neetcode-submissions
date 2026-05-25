class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val target = IntArray(26)
        for (c in s1) {
            target[c - 'a']++
        }

        val current = IntArray(26)
        var left = 0
        var right = 0
        while (right < s2.length) {
            current[s2[right] - 'a']++
            right++
            if (right - left < s1.length) continue

            if (current.contentEquals(target)) return true
            current[s2[left] - 'a']--
            left++
        }
        return false
    }
}

/**
Permutation means same characters but different order.
I need to count all characters in s1.
Then I use a sliding window that fixes the length of s1
and check whether this interval substring is permutation or not.
**/
