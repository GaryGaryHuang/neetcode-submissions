class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return listOf()

        val dToS = mapOf(
            '2' to "abc", '3' to "def", '4' to "ghi", '5' to "jkl",
            '6' to "mno", '7' to "pqrs", '8' to "tuv", '9' to "wxyz",
        )

        val res = mutableListOf<String>()
        val strBuilder = StringBuilder()
        fun dfs(index: Int) {
            if (index == digits.length) {
                res.add(strBuilder.toString())
                return
            }

            val d = digits[index]
            for (c in dToS[d]!!) {
                strBuilder.append(c)
                dfs(index + 1)
                strBuilder.deleteAt(strBuilder.length - 1)
            }
        }

        dfs(0)
        return res
    }
}
