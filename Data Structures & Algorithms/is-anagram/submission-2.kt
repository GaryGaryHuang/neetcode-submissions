class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val array = IntArray(26)
        for (c in s) {
            array[c - 'a']++
        }
        for (c in t) {
            array[c - 'a']--
        }

        for (c in array) {
            if (c != 0) {
                return false
            }
        }
        return true
    }
}
