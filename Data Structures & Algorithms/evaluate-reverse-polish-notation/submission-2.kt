class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val operators = setOf("+", "-", "*", "/")
        val arrayDeque = ArrayDeque<Int>()
        for (s in tokens) {
            if (s !in operators) {
                arrayDeque.add(s.toInt())
            } else {
                val num2 = arrayDeque.removeLast()
                val num1 = arrayDeque.removeLast()
                when (s) {
                    "+" -> arrayDeque.add(num1 + num2)
                    "-" -> arrayDeque.add(num1 - num2)
                    "*" -> arrayDeque.add(num1 * num2)
                    else -> arrayDeque.add(num1 / num2)
                }
            }
        }
        return arrayDeque.last()
    }
}

/**
Push every number onto a stack.
When an operator appears,
pop the two numbers, calculate the result, and push it back onto the Stack.
*/
