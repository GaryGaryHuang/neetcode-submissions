class Solution {
    /**
    Format every string into "$length#$string"
    **/
    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        for (s in strs) {
            builder.append("${s.length}#${s}")
        }
        return builder.toString()
    }

    fun decode(str: String): List<String> {

        val list = mutableListOf<String>()
        var start = 0
        while (start < str.length) {
            var end = start
            while (end < str.length && str[end] != '#') end++

            val length = str.substring(start, end).toInt()
            start = end + 1
            end = start + length
            list.add(str.substring(start, end))

            start = end
        }
        return list
    }
}
