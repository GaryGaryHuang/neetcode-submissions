/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var max = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val left = dfs(node.left)
            val right = dfs(node.right)

            max = maxOf(max, left + right)
            return maxOf(left, right) + 1
        }

        dfs(root)
        return max
    }
}

/**
Given a node, I can know the depth of left and right nodes.
For each node, the max length is the left length + the right length.
Then we can keep the left path or the right path 
so that it can be combined with the other ndoe's left path or right path.
*/
