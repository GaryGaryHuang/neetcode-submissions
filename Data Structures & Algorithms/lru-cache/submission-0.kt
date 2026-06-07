class LRUCache(private val capacity: Int) {
    private val keyToNode = mutableMapOf<Int, LinkedList>()
    private var head: LinkedList? = null
    private var tail: LinkedList? = null

    fun get(key: Int): Int {
        val node = keyToNode[key] ?: return -1
        moveToTheFirst(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = keyToNode.getOrPut(key) { LinkedList(key, value) }
        node.value = value

        if (tail != null && node == head) tail = tail!!.left
        if (head == null) {
            head = node
            tail = node
        }
        if (head != node) moveToTheFirst(node)

        if (keyToNode.size > capacity) {
            val leftNode = tail!!.left!!
            leftNode.right = null
            keyToNode.remove(tail!!.key)
            tail = leftNode
        }
    }

    private fun moveToTheFirst(node: LinkedList) {
        val leftNode = node.left
        //  Left node's next points to the node's right
        leftNode?.right = node.right

        node.left = null
        node.right = head
        head?.left = node
        
        head = node
    }
}

data class LinkedList(
    val key: Int,
    var value: Int,
    var left: LinkedList? = null,
    var right: LinkedList? = null,
)

/**
Use a Map store key and node, so that I can get the node in O(1).
Use a LinkedList to move the node to the first
when `get` and `put` are called.
We need to remove the the least recently used node if the capacity is full.
Because we need to know the last node in a LinkedList,
we need a extra reverse LinkedList.
When `get` is called, I find the node in the map to check whether the node exists.
If not, use this node to point the LinkedList, 
and use the rerverse LinkedList point to this node.
If the node exists, move the node to the first one 
and move the node the the last one in the reversed LinkedList.
*/
