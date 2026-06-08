/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val levels = mutableListOf<MutableList<Int>>()

        fun dfs(depth: Int, current: TreeNode?) {
            if (current == null) return

            if (depth == levels.size) levels.add(mutableListOf())
            levels[depth].add(current.`val`)

            dfs(depth + 1, current.left)
            dfs(depth + 1, current.right)
        }

        dfs(0, root)
        return levels
    }
}

/**
Use pre-order to put all node in the corresponding list.
*/
