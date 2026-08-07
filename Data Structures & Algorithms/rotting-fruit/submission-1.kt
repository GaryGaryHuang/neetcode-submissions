class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) }

        fun bfs(start: List<Pair<Int, Int>>): Int {
            if (start.isEmpty()) return 0

            var minutes = 0
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.addAll(start)
            while (queue.isNotEmpty()) {
                val size = queue.size
                println(size)
                repeat(size) {
                    val (r, c) = queue.removeFirst()
                    if (r > 0 && !visited[r - 1][c] && grid[r - 1][c] == 1) {
                        queue.add(Pair(r - 1, c))
                        visited[r - 1][c] = true
                    }
                    if (c > 0 && !visited[r][c - 1] && grid[r][c - 1] == 1) {
                        queue.add(Pair(r, c - 1))
                        visited[r][c - 1] = true
                    }
                    if (r < m - 1 && !visited[r + 1][c] && grid[r + 1][c] == 1) {
                        queue.add(Pair(r + 1, c))
                        visited[r + 1][c] = true
                    }
                    if (c < n - 1 && !visited[r][c + 1] && grid[r][c + 1] == 1) {
                        queue.add(Pair(r, c + 1))
                        visited[r][c + 1] = true
                    }
                }
                minutes++
            }
            return minutes - 1
        }

        val rotten = mutableListOf<Pair<Int, Int>>()
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == 2) {
                    rotten.add(Pair(r, c))
                    visited[r][c] = true
                }
            }
        }

        val minutes = bfs(rotten)
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (!visited[r][c] && grid[r][c] == 1) return -1
            }
        }
        return minutes
    }
}
