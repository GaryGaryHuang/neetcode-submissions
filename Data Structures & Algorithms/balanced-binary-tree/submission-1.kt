/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        var maxDiff = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val left = dfs(node.left)
            val right = dfs(node.right)
            maxDiff = maxOf(maxDiff, left - right, right - left)

            return 1 + maxOf(left, right)
        }

        dfs(root)
        return if (maxDiff <= 1) true else false
    }
}
