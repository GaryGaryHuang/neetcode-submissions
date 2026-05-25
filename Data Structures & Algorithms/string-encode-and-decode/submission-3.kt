class Solution {

    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        for (s in strs) {
            builder.append(s.length)
                .append('#')
                .append(s)
        }
        return builder.toString()
    }

    fun decode(str: String): List<String> {
        val res = mutableListOf<String>()
        var currentIndex = 0
        while (currentIndex < str.length) {
            var targetIndex = currentIndex + 1
            while (targetIndex < str.length && str[targetIndex] != '#') {
                targetIndex++
            }

            val length: Int = str.substring(currentIndex, targetIndex).toInt()
            currentIndex = targetIndex + 1
            res.add(str.substring(currentIndex, currentIndex + length))
            currentIndex += length
        }
        return res
    }
}
