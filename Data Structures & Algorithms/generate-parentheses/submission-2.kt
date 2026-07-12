class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        val strBuilder = StringBuilder()

        fun dfs(left: Int, right: Int) {
            if (left == n && right == n) {
                res.add(strBuilder.toString())
                return
            }

            if (left == right || left < n) {
                strBuilder.append('(')
                dfs(left + 1, right)
                strBuilder.deleteAt(strBuilder.length - 1)
            }
            if (left == right) return

            strBuilder.append(')')
            dfs(left, right + 1)
            strBuilder.deleteAt(strBuilder.length - 1)
        }

        dfs(0, 0)
        return res
    }
}
