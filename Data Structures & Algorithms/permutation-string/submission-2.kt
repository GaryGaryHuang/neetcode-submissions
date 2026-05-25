class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val target = IntArray(26)
        for (c in s1) {
            target[c - 'a']++
        }

        val array = IntArray(26)
        var l = 0
        var r = 0
        while (r < s2.length) {
            array[s2[r] - 'a']++
            var length = r - l + 1
            if (length > s1.length) {
                array[s2[l] - 'a']--
                l++
                length--
            }
            if (length == s1.length && checkPermutation(target, array)) {
                return true
            }
            r++
        }
        return false
    }

    private fun checkPermutation(target: IntArray, current: IntArray): Boolean {
        for (i in 0 until target.size) {
            if (target[i] != current[i]) return false
        }
        return true
    }
}
