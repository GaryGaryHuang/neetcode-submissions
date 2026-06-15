class Solution {
    fun letterCombinations(digits: String): List<String> {
        val cToS = mutableMapOf(
            '2' to "abc", '3' to "def", '4' to "ghi", '5' to "jkl",
            '6' to "mno", '7' to "pqrs", '8' to "tuv", '9' to "wxyz",
        )

        val res = mutableListOf<String>()

        val builder = StringBuilder()
        fun dfs(index: Int) {
            if (index == digits.length) {
                if (builder.length > 0) res.add(builder.toString())
                return
            }

            val digit = digits[index]
            for (c in cToS[digit]!!) {
                builder.append(c)
                dfs(index + 1)
                builder.deleteCharAt(builder.length - 1)
            }
        }

        dfs(0)
        return res
    }
}

/**
Each char can be mapped to a string, such as 2 -> "abc" and 3 -> "def", 
allowing us to generate all combinations.
*/
