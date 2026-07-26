/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0

        fun dfs(prev: Int, node: TreeNode?): Int {
            if (node == null) return 0

            val max = maxOf(prev, node.`val`)
            var total = dfs(max, node.left) + dfs(max, node.right)
            if (node.`val` >= prev) total++

            return total
        }

        return dfs(root.`val`, root)
    }
}

//  dfs
