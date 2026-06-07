/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        
        fun dfs(node: TreeNode?) {
            if (node == null) return

            val temp = node.left
            node.left = node.right
            node.right = temp

            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)
        return root
    }
}
