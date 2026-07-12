class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val visited = Array(board.size) { BooleanArray(board[0].size) }
        fun dfs(x: Int, y: Int, index: Int): Boolean {
            if (index == word.length) return true
            if (x !in 0 until board.size || y !in 0 until board[0].size) return false
            if (visited[x][y] || board[x][y] != word[index]) return false

            visited[x][y] = true
            val next = dfs(x + 1, y, index + 1) ||
                dfs(x - 1, y, index + 1) ||
                dfs(x, y + 1, index + 1) ||
                dfs(x, y - 1, index + 1)
            visited[x][y] = false
            return next
        }

        for (x in 0 until board.size) {
            for (y in 0 until board[0].size) {
                if (dfs(x, y, 0)) return true
            }
        }
        return false
    }
}
