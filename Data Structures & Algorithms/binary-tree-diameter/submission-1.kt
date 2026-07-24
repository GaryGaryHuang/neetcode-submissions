/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var longest = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val leftLen = dfs(node.left)
            val rightLen = dfs(node.right)
            longest = maxOf(longest, leftLen + rightLen)

            return 1 + maxOf(leftLen, rightLen)
        }

        dfs(root)
        return longest
    }
}

/**
At each node, I can determine the depths of its left and right subtrees. 
The total path length through the node is the sum of these depths, 
and I can keep track of the maximum path length encountered. 
After calculating the path length at the current node, 
I return the greater of the two subtree depths to the parent, 
which uses it to perform the same calculation.
*/
