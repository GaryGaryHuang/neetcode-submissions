class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()

        val path = StringBuilder()
        fun dfs(open: Int, close: Int) {
            if (open == n && close == n) {
                res.add(path.toString())
                return
            }

            if (open < n) {
                path.append('(')
                dfs(open + 1, close)
                path.deleteCharAt(path.length - 1)
            }

            if (close < open) {
                path.append(')')
                dfs(open, close + 1)
                path.deleteCharAt(path.length - 1)
            }
        }

        dfs(0, 0)
        return res
    }
}
