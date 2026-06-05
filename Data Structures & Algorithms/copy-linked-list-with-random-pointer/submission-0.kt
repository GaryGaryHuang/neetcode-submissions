/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        if (head == null) return null

        val nodeToOrder = mutableMapOf<Node, Int>()
        var current = head
        var index = 0
        while (current != null) {
            nodeToOrder[current] = index
            index++
            current = current.next
        }

        val randomIndices = IntArray(index) { -1 }
        current = head
        index = 0
        while (current != null) {
            val random = current.random
            if (random != null) {
                randomIndices[index] = nodeToOrder[random] ?: -1
            }
            index++
            current = current.next
        }

        val newNodes = Array<Node?>(index) { null }
        for ((node, index) in nodeToOrder) {
            newNodes[index] = Node(node.`val`)
        }

        for (i in 0 until index) {
            if (i < index - 1) newNodes[i]!!.next = newNodes[i + 1]
            if (randomIndices[i] >= 0) {
                newNodes[i]!!.random = newNodes[randomIndices[i]]
            }
        }

        return newNodes[0]
    }
}

/**
A linked list has an order, so I want to know the order of each node and the order of its random node. 
Then I can reconstruct the entire map.

I would store each node and its order in a map: Map<Node, node index>.
I would store the order of each node’s random node in a list: List<the random node’s order>.
I would also store all nodes in a list by their order.
*/
