/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val res = mutableListOf<List<Int>>()

        val arrayDeque = ArrayDeque<TreeNode>()
        arrayDeque.add(root)
        while (arrayDeque.isNotEmpty()) {
            val currentSize = arrayDeque.size
            val nums = mutableListOf<Int>()
            repeat(currentSize) {
                val node = arrayDeque.removeFirst()
                node.left?.let{ arrayDeque.add(it) }
                node.right?.let{ arrayDeque.add(it) }
                nums.add(node.`val`)
            }
            res.add(nums)
        }
        return res
    }
}

//  BFS
