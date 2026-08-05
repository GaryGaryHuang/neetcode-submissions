class LRUCache(private val capacity: Int) {
    private val keyToNode = mutableMapOf<Int, Node>()
    private val head = Node(-1, 0)
    private val tail = Node(-1, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = keyToNode[key] ?: return -1
        remove(node)
        addToFirst(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        keyToNode[key]?.let { remove(it) }

        addToFirst(Node(key, value))

        if (keyToNode.size > capacity) {
            remove(tail.prev ?: return)
        }
    }

    private fun remove(node: Node) {
        node.prev!!.next = node.next
        keyToNode.remove(node.key)
    }

    private fun addToFirst(node: Node) {
        node.prev = head
        node.next = head.next
        head.next!!.prev = node
        head.next = node
        keyToNode[node.key] = node
    }
}

class Node(
    val key: Int,
    val value: Int,
    var prev: Node? = null,
    var next: Node? = null,
)
