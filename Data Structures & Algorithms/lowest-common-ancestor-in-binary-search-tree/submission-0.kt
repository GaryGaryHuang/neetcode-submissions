/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) return null

        val small = minOf(p.`val`, q.`val`)
        val big = maxOf(p.`val`, q.`val`)
        if (root.`val` in small..big) return root
        if (root.`val` == p.`val` || root.`val` == q.`val`) return root
        return if (small > root.`val`) lowestCommonAncestor(root.right, p, q)
        else lowestCommonAncestor(root.left, p, q)
    }
}

/**
If the current value is between small node and big node,
it means the current node is the answer.
If the small node and big are larger than the current node value, go right; otherwise, go left.
If the current node is either small node or big node, the current node is also the answer.
*/