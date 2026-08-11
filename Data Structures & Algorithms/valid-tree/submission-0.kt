class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val nToEdges = mutableMapOf<Int, MutableList<Int>>()
        for ((node, edge) in edges) {
            nToEdges.getOrPut(node) { mutableListOf<Int>() }.add(edge)
            nToEdges.getOrPut(edge) { mutableListOf<Int>() }.add(node)
        }

        val visiting = mutableSetOf<Int>()
        val visited = mutableSetOf<Int>()
        fun dfs(last: Int, node: Int): Boolean {
            if (node in visiting) return false
            if (node in visited) return true

            visiting.add(node)
            for (edge in nToEdges[node].orEmpty()) {
                if (edge == last) continue
                if (!dfs(node, edge)) return false
            }
            visiting.remove(node)

            visited.add(node)
            return true
        }

        if (!dfs(0, 0)) return false
        return visited.size == n
    }
}
