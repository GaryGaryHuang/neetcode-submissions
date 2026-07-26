/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
        if (root == null) return null
        if (p.`val` > q.`val`) return lowestCommonAncestor(root, q, p)
        if (root.`val` == p.`val`) return p
        if (root.`val` == q.`val`) return q
        if (p.`val` < root.`val` && q.`val` > root.`val`) return root
        if (p.`val` < root.`val` && q.`val` < root.`val`) return lowestCommonAncestor(root.left, p, q)
        return lowestCommonAncestor(root.right, p, q)
    }
}

/**
For Example 1:
p = 3, q = 8
Start at the root node and determine whether p and q are on the same side. 
The root value is 5. Since p is less than 5, p is on the left side. 
Since q is greater than 5, q is on the right side. 
Because p and q are on opposite sides, the root is their LCA.

For Example 2:
p = 3, q = 4
Both p and q are less than the root value, so move to the left subtree. 
The current node is 3, which is the same as p. Therefore, p is the LCA.
*/
