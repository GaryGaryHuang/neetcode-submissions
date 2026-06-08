/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (root == null) return false

        return isSameTree(root, subRoot) ||
            isSubtree(root.left, subRoot) ||
            isSubtree(root.right, subRoot)
    }

    private fun isSameTree(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null && b == null) return true
        if (a == null || b == null) return false
        if (a.`val` != b.`val`) return false

        return isSameTree(a.left, b.left) &&
            isSameTree(a.right, b.right)
    }
}
/**
A tree is called subtree, where its root and its children are all the same.
Find the same root value and check all children.
*/
