/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {

        fun isValid(node: TreeNode?, min: Int?, max: Int?): Boolean {
            if (node == null) return true
            if (min != null && node.`val` <= min) return false
            if (max != null && node.`val` >= max) return false
            return isValid(node.left, min, node.`val`) && isValid(node.right, node.`val`, max)
        }

        return isValid(root, null, null)
    }
}

/**
All node values on the left-hand side must be smaller than the current node value.  
All node values on the right-hand side must be greater than the current node value.
At each iteration, we need to know either the minimum or maximum allowed value.
For the left-hand side, use the maximum allowed value; for the right-hand side, use the minimum allowed value.
*/
