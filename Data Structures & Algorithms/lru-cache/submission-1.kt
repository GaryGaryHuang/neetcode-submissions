class LRUCache(private val capacity: Int) {
    private class Node(
        val key: Int,
        var value: Int
    ) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val keyToNode = mutableMapOf<Int, Node>()

    // head.next = most recently used
    // tail.prev = least recently used
    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = keyToNode[key] ?: return -1

        remove(node)
        addToFront(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        val existingNode = keyToNode[key]

        if (existingNode != null) {
            existingNode.value = value
            remove(existingNode)
            addToFront(existingNode)
            return
        }

        val newNode = Node(key, value)
        keyToNode[key] = newNode
        addToFront(newNode)

        if (keyToNode.size > capacity) {
            val leastRecentlyUsed = tail.prev!!
            remove(leastRecentlyUsed)
            keyToNode.remove(leastRecentlyUsed.key)
        }
    }

    private fun addToFront(node: Node) {
        val first = head.next!!

        node.prev = head
        node.next = first

        head.next = node
        first.prev = node
    }

    private fun remove(node: Node) {
        val prevNode = node.prev!!
        val nextNode = node.next!!

        prevNode.next = nextNode
        nextNode.prev = prevNode
    }
}