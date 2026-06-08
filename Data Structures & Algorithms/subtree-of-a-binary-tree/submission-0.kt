/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if (root == null || subRoot == null) return false
        
        if (root.`val` == subRoot.`val`) {
            if (isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right)) {
                return true
            }
        }

        return isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }
}

/**
A tree is called subtree, where its root and its children are all the same.
Find the same root value and check all children.
*/
