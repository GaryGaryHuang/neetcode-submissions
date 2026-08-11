class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val nToEdges = mutableMapOf<Int, MutableList<Int>>()
        for ((node, edge) in edges) {
            nToEdges.getOrPut(node) { mutableListOf<Int>() }.add(edge)
            nToEdges.getOrPut(edge) { mutableListOf<Int>() }.add(node)
        }

        val visited = mutableSetOf<Int>()
        fun dfs(parent: Int, node: Int): Boolean {
            if (node in visited) return false

            visited.add(node)
            for (edge in nToEdges[node].orEmpty()) {
                if (edge == parent) continue
                if (!dfs(node, edge)) return false
            }
            return true
        }

        return dfs(-1, 0) && visited.size == n
    }
}
