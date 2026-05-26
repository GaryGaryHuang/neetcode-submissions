class MinStack() {
    //  <Value, Min value>
    private val arrayDeque = ArrayDeque<Pair<Int, Int>>()

    fun push(`val`: Int) {
        val min = if (arrayDeque.isEmpty()) `val` else minOf(`val`, arrayDeque.last().second)
        arrayDeque.addLast(Pair(`val`, min))
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
Stack is first in last out.
If I need to know the min value in O(1) time,
I need to keep the min value in every operqation.
When I push a new value, I also keep the min value so far.
*/
