/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()

        fun dfs(depth: Int, current: TreeNode?) {
            if (current == null) return

            if (res.size <= depth) res.add(mutableListOf())
            res[depth].add(current.`val`)

            dfs(depth + 1, current.left)
            dfs(depth + 1, current.right)
        }

        dfs(0, root)
        return res
    }
}

/**
Use pre-order to put all node in the corresponding list.
*/
