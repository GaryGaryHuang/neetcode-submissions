class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val target = IntArray(26)
        for (c in s1) {
            target[c - 'a']++
        }

        val array = IntArray(26)
        var left = 0
        var right = 0
        while (right < s2.length) {
            array[s2[right] - 'a']++
            if (right - left + 1 > s1.length) {
                array[s2[left] - 'a']--
                left++
            }
            if (target.contentEquals(array)) return true
            right++
        }
        return false
    }
}
