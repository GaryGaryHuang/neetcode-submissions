class Solution {
    fun minWindow(s: String, t: String): String {
        val target = IntArray(52)
        for (c in t) {
            target[convertIndex(c)]++
        }

        var res = ""
        var left = 0
        var right = 0
        var array = IntArray(52)
        while (right < s.length) {
            array[convertIndex(s[right])]++
            while (isExist(target, array)) {
                if (res.length == 0) res = s.substring(left, right + 1)
                else if (right - left + 1 <= res.length) res = s.substring(left, right + 1)
                array[convertIndex(s[left])]--
                left++
            }
            right++
        }
        return res
    }

    private fun convertIndex(c : Char): Int {
        if (c in 'A'..'Z') return c - 'A'
        else return 26 + (c - 'a')
    }

    private fun isExist(target: IntArray, array: IntArray): Boolean {
        for (i in 0 until target.size) {
            if (array[i] < target[i]) return false
        }
        return true
    }
}

/**
Count the frequency of `t` 
and check whether the substring of `s` matches `t`’s frequency.
*/