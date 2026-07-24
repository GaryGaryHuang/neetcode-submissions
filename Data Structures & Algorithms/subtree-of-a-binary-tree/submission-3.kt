/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        
        fun dfs(node1: TreeNode?, node2: TreeNode?): Boolean {
            if (node1 == null && node2 == null) return true
            if (node1 == null || node2 == null) return false

            if (node1.`val` == node2.`val`) {
                if (dfs(node1.left, node2.left) && dfs(node1.right, node2.right)) return true
            }
            
            if (node2 != subRoot) return false
            return dfs(node1.left, node2) || dfs(node1.right, node2)
        }

        return dfs(root, subRoot)
    }
}
