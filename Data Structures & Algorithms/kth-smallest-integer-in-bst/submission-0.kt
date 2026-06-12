/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var count = 0
        var res = -1

        fun dfs(node: TreeNode?): Boolean {
            if (node == null) return false
            if (dfs(node.left)) return true

            count++
            if (count == k) {
                res = node.`val`
                return true
            }

            return dfs(node.right)
        }

        dfs(root)
        return res
    }
}
