/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        if (root == null) return res

        val arrayDeque = ArrayDeque<TreeNode>()
        arrayDeque.add(root)

        while (arrayDeque.isNotEmpty()) {
            val size = arrayDeque.size
            res.add(arrayDeque.first().`val`)
            repeat(size) {
                val node = arrayDeque.removeFirst()
                if (node.right != null) arrayDeque.add(node.right)
                if (node.left != null) arrayDeque.add(node.left)
            }
        }

        return res
    }
}

/**
Use bfs to interate all node from top to bottom.
In each level, put the nodes from right to left
so that we know the first node value is the most left node.
*/
