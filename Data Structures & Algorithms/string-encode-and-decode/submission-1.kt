class Solution {

    fun encode(strs: List<String>): String {
        if (strs.size == 0) return ""
        return SPLIT + strs.joinToString(SPLIT)
    }

    fun decode(str: String): List<String> {
        if (str.isEmpty()) return listOf()
        return str.split(SPLIT).drop(1).toList()
    }

    companion object {
        private const val SPLIT = "##@@##"
    }
}
