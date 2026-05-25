class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val arrays = IntArray(26)
        val arrayt = IntArray(26)

        val len = s.length
        for (i in 0 until len) {
            arrays[s[i] - 'a']++
            arrayt[t[i] - 'a']++
        }

        for (i in 0..25) {
            if (arrays[i] != arrayt[i]) return false
        }
        return true
    }
}

// Two strings are called anagrams if:
// 1. their lengths are the same
// 2. they contain the same characters as another string

// How to check whether they contain the same characters as another string
// I can count every character for these two strings