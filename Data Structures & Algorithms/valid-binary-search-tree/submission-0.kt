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
        if (root.left != null && root.left!!.`val` >= root.`val`) return false
        if (root.right != null && root.right!!.`val` <= root.`val`) return false
        return isValidBST(root.left) && isValidBST(root.right)
    }
}
