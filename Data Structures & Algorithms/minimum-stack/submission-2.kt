class MinStack() {
    //  value, minValue
    private val arrayDeque = ArrayDeque<Pair<Int, Int>>()

    fun push(value: Int) {
        val min = if (arrayDeque.isEmpty()) value else minOf(value, arrayDeque.last().second)
        arrayDeque.add(Pair(value, min))
    }

    fun pop() {
        arrayDeque.removeLast()
    }

    fun top(): Int {
        return arrayDeque.last().first
    }

    fun getMin(): Int {
        return arrayDeque.last().second
    }
}

/**
A stack follows the last-in, first-out rule. 
Since we know each number when we add it to an array, 
we can keep the minimum value whenever a new number arrives. 
This way, we always know the minimum value at any moment.
*/
