class Solution {
    fun minWindow(s: String, t: String): String {
        val target = IntArray(52)
        for (c in t) {
            target[toIndex(c)]++
        }

        var res = ""
        val current = IntArray(52)
        var left = 0
        for (right in 0 until s.length) {
            current[toIndex(s[right])]++
            while (isSubstring(target, current)) {
                if (res.length == 0 || res.length >= (right - left + 1)) {
                    res = s.substring(left, right + 1)
                }
                current[toIndex(s[left])]--
                left++
            }
        }
        return res
    }

    private fun isSubstring(target: IntArray, current: IntArray): Boolean {
        for (i in 0 until target.size) {
            if (current[i] < target[i]) return false
        }
        return true
    }

    private fun toIndex(char: Char): Int {
        if (char in 'A'..'Z') return char - 'A'
        return 26 + (char - 'a')
    }
}

/**
Count the frequency of each char in t, 
then scan s and compare the frequency counts. 

A match means that every char in s 
appears at least as many times as required by t.

If the window matches, I can move the left boundary to the right until it no longer matches, 
since I want the shortest substring.
*/
