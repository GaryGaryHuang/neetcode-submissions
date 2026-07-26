/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val res = mutableListOf<Int>()
        val arrayDeque = ArrayDeque<TreeNode>()
        arrayDeque.add(root)
        while (arrayDeque.isNotEmpty()) {
            val levelSize = arrayDeque.size
            repeat(levelSize - 1) {
                arrayDeque.removeFirst().let { node ->
                    node.left?.let { arrayDeque.add(it) }
                    node.right?.let { arrayDeque.add(it) }
                }
            }
            arrayDeque.removeFirst().let { node ->
                node.left?.let { arrayDeque.add(it) }
                node.right?.let { arrayDeque.add(it) }
                res.add(node.`val`)
            }
        }
        return res
    }
}

//  BFS
