/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val leftDepth = dfs(node.left)
            val rightDepth = dfs(node.right)
            if (leftDepth == -1 || rightDepth == -1) return -1
            return if (Math.abs(leftDepth - rightDepth) > 1) -1 else 1 + maxOf(leftDepth, rightDepth)
        }

        return dfs(root) != -1
    }
}
