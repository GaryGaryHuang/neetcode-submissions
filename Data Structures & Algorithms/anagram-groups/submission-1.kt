class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        for (s in strs) {
            val count = IntArray(26)
            for (c in s) {
                count[c - 'a']++
            }
            val key = count.joinToString("-")
            map.getOrPut(key) { mutableListOf<String>() }.add(s)
        }
        return map.values.map { it }
    }
}
