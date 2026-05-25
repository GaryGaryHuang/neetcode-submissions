class MinStack() {
    //  <current value, min value at this point>
    private val deque = ArrayDeque<Pair<Int, Int>>()

    fun push(`val`: Int) {
        val min = if (deque.isEmpty()) {
            `val`
        } else {
            minOf(`val`, deque.last().second)
        }
        deque.addLast(Pair(`val`, min))
    }

    fun pop() {
        deque.removeLast()
    }

    fun top(): Int {
        return deque.last().first
    }

    fun getMin(): Int {
        return deque.last().second
    }
}
