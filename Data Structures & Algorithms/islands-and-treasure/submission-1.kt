class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val m = grid.size
        val n = grid[0].size

        fun bfs(start: List<Pair<Int, Int>>) {
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.addAll(start)

            var distance = 1
            while (queue.isNotEmpty()) {
                val size = queue.size
                repeat(size) {
                    val (r, c) = queue.removeFirst()
                    if (r > 0 && grid[r - 1][c] > 0 && distance < grid[r - 1][c]) {
                        grid[r - 1][c] = distance
                        queue.add(Pair(r - 1, c))
                    }
                    if (c > 0 && grid[r][c - 1] > 0 && distance < grid[r][c - 1]) {
                        grid[r][c - 1] = distance
                        queue.add(Pair(r, c - 1))
                    }
                    if (r < m - 1 && grid[r + 1][c] > 0 && distance < grid[r + 1][c]) {
                        grid[r + 1][c] = distance
                        queue.add(Pair(r + 1, c))
                    }
                    if (c < n - 1 && grid[r][c + 1] > 0 && distance < grid[r][c + 1]) {
                        grid[r][c + 1] = distance
                        queue.add(Pair(r, c + 1))
                    }
                }
                distance++
            }
        }

        val starts = mutableListOf<Pair<Int, Int>>()
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == 0) starts.add(Pair(r, c))
            }
        }
        bfs(starts)
    }
}
