class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val arrayS = IntArray(26)
        val arrayT = IntArray(26)
        
        val len = s.length
        for (i in 0 until len) {
            arrayS[s[i] - 'a']++
            arrayT[t[i] - 'a']++
        }

        for (i in 0 until 26) {
            if (arrayS[i] != arrayT[i]) {
                return false
            }
        }

        return true
    }
}

// I will count the occurrences of each character in the array to determine whether they are anagrams.
// I found an edge case: if their lengths differ, I can return false immediately.