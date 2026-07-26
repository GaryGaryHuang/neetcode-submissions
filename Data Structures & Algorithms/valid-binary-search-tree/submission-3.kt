/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return left(null, root.`val`, root.left) && right(root.`val`, null, root.right)
    }

    private fun left(min: Int?, max: Int, node: TreeNode?): Boolean {
        if (node == null) return true
        if (node.`val` >= max) return false
        if (min != null && node.`val` <= min) return false
        return left(
            min = min,
            max = node.`val`,
            node = node.left,
        ) && right(
            min = node.`val`,
            max = max,
            node = node.right,
        )
    }

    private fun right(min: Int, max: Int?, node: TreeNode?): Boolean {
        if (node == null) return true
        if (node.`val` <= min) return false
        if (max != null && node.`val` >= max) return false
        return left(
            min = min,
            max = node.`val`,
            node = node.left,
        ) && right(
            min = node.`val`,
            max = max,
            node = node.right,
        )
    }
}
