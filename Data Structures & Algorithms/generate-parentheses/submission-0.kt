class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val len = 2 * n

        val res = mutableListOf<String>()
        val path = mutableListOf<Char>()
        fun dfs(left: Int, right: Int) {
            if (right > left || left > n || right > n) return
            if (left + right == len) {
                res.add(path.joinToString(""))
                return
            }

            path.add('(')
            dfs(left + 1, right)
            path.removeLast()

            path.add(')')
            dfs(left, right + 1)
            path.removeLast()
        }

        dfs(0, 0)
        return res
    }
}
