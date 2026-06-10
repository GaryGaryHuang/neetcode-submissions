/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        var count = 0

        val arrayDeque = ArrayDeque<Int>()
        fun dfs(node: TreeNode?) {
            if (node == null) return

            if (arrayDeque.isEmpty() || node.`val` >= arrayDeque.last()) count++

            arrayDeque.add(
                if (arrayDeque.isEmpty()) node.`val`
                else maxOf(arrayDeque.last(), node.`val`)
            )

            dfs(node.left)
            dfs(node.right)
            arrayDeque.removeLast()
        }

        dfs(root)
        return count
    }
}

/**
I would use dfs to interate all nodes, and put the max value when visiting a node.
*/
