class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val m = heights.size
        val n = heights[0].size

        fun bfs(list: List<Pair<Int, Int>>, visited: Array<BooleanArray>) {
            val queue = ArrayDeque<Pair<Int, Int>>()
            queue.addAll(list)
            list.forEach { visited[it.first][it.second] = true }
            
            while (queue.isNotEmpty()) {
                val (r, c) = queue.remove()
                if (r > 0 && !visited[r - 1][c] && heights[r - 1][c] >= heights[r][c]) {
                    queue.add(Pair(r - 1, c))
                    visited[r - 1][c] = true
                }
                if (c > 0 && !visited[r][c - 1] && heights[r][c - 1] >= heights[r][c]) {
                    queue.add(Pair(r, c - 1))
                    visited[r][c - 1] = true
                }
                if (r < m - 1 && !visited[r + 1][c] && heights[r + 1][c] >= heights[r][c]) {
                    queue.add(Pair(r + 1, c))
                    visited[r + 1][c] = true
                }
                if (c < n - 1 && !visited[r][c + 1] && heights[r][c + 1] >= heights[r][c]) {
                    queue.add(Pair(r, c + 1))
                    visited[r][c + 1] = true
                }
            }
        }

        val topLeft = mutableListOf<Pair<Int, Int>>()
        val pacific = Array(m) { BooleanArray(n) }
        repeat(n) { topLeft.add(Pair(0, it)) }
        repeat(m) { topLeft.add(Pair(it, 0)) }
        bfs(topLeft, pacific)

        val rightBottom = mutableListOf<Pair<Int, Int>>()
        val atlantic = Array(m) { BooleanArray(n) }
        repeat(m) { rightBottom.add(Pair(it, n - 1)) }
        repeat(n) { rightBottom.add(Pair(m - 1, it)) }
        bfs(rightBottom, atlantic)

        val intersect = mutableListOf<List<Int>>()
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (pacific[r][c] && atlantic[r][c]) intersect.add(listOf(r, c))
            }
        }
        return intersect
    }
}
