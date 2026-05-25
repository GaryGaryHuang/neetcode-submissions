class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var res = 0

        var left = 0
        for (i in 0 until s.length) {
            val char = s[i]
            while (left < i && char in set) {
                set.remove(s[left])
                left++
            }
            set.add(s[i])
            res = maxOf(res, i - left + 1)
        }

        return res
    }
}
