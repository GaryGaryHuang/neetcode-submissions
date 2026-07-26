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
            res.add(arrayDeque.first().`val`)
            repeat(levelSize) {
                arrayDeque.removeFirst().let { node ->
                    node.right?.let { arrayDeque.add(it) }
                    node.left?.let { arrayDeque.add(it) }
                }
            }
        }
        return res
    }
}

//  BFS
