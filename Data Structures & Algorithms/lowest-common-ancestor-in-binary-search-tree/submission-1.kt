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

        val low = minOf(p.`val`, q.`val`)
        val high = maxOf(p.`val`, q.`val`)
        val value = root.`val`

        return when {
            value < low -> lowestCommonAncestor(root.right, p, q)
            value > high -> lowestCommonAncestor(root.left, p, q)
            else -> root
        }
    }
}

/**
If the current value is between small node and big node,
it means the current node is the answer.
If the small node and big are larger than the current node value, go right; otherwise, go left.
If the current node is either small node or big node, the current node is also the answer.
*/