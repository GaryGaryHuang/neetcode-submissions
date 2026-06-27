class Solution {
    fun minWindow(s: String, t: String): String {
        val freqT = IntArray(52)
        for (c in t) {
            freqT[toIndex(c)]++
        }

        var res = ""
        val freqS = IntArray(52)
        var left = 0
        for (right in 0 until s.length) {
            freqS[toIndex(s[right])]++
            while (right - left + 1 >= t.length && isValid(freqS, freqT)) {
                if (res.isEmpty() || right - left + 1 < res.length) {
                    res = s.substring(left, right + 1)
                }
                freqS[toIndex(s[left])]--
                left++
            }
        }
        return res
    }

    private fun isValid(s: IntArray, t: IntArray): Boolean {
        for (i in 0 until s.size) {
            if (s[i] < t[i]) return false
        }
        return true
    }

    private fun toIndex(c: Char): Int {
        return if (c in 'A'..'Z') c - 'A' else 26 + (c - 'a')
    }
}
