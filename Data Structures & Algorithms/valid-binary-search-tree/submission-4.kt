/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {

        fun isValid(min: Int?, max: Int?, node: TreeNode?): Boolean {
            if (node == null) return true

            if (min != null && node.`val` <= min) return false
            if (max != null && node.`val` >= max) return false

            return isValid(min, node.`val`, node.left) &&
                isValid(node.`val`, max, node.right)
        }

        return isValid(null, null, root)
    }
}
