class Solution {
    fun characterReplacement(s: String, k: Int): Int {

        fun replace(c: Char): Int {
            var res = 0
            var left = 0
            var remain = k
            for (i in 0 until s.length) {
                if (s[i] != c) remain--
                while (remain < 0) {
                    if (s[left] != c) remain++
                    left++
                }
                res = max(res, i - left + 1)
            }
            return res
        }

        var res = 0
        for (c in 'A'..'Z') {
            res = max(res, replace(c))
        }
        return res
    }
}
