class Solution {
    fun solve(board: Array<CharArray>) {
        val m = board.size
        val n = board[0].size

        fun bfs(list: List<Pair<Int, Int>>, signal: Char) {
            val dirs = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.addAll(list)
            list.forEach { board[it.first][it.second] = signal }

            while (queue.isNotEmpty()) {
                val (r, c) = queue.remove()
                for (d in dirs) {
                    val (nr, nc) = (r + d.first) to (c + d.second)
                    if (
                        nr in 0 until m
                        && nc in 0 until n
                        && board[nr][nc] == 'O'
                    ) {
                        board[nr][nc] = signal
                        queue.add(Pair(nr, nc))
                    }
                }
            }
        }

        val list = mutableListOf<Pair<Int, Int>>()
        repeat(n) { if (board[0][it] == 'O') list.add(Pair(0, it)) }
        repeat(m) { if (board[it][n - 1] == 'O') list.add(Pair(it, n - 1)) }
        repeat(n) { if (board[m - 1][it] == 'O') list.add(Pair(m - 1, it)) }
        repeat(n) { if (board[it][0] == 'O') list.add(Pair(it, 0)) }

        val signal = '!'
        bfs(list, signal)
        for (r in 0 until m) {
            for (c in 0 until n) {
                board[r][c] = if (board[r][c] == '!') 'O' else 'X' 
            }
        }
    }
}
