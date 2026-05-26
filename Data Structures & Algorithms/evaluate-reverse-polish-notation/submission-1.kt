class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val operations = setOf("+", "-", "*", "/")
        val arrayDeque = ArrayDeque<Int>()
        for (s in tokens) {
            if (s !in operations) {
                arrayDeque.addLast(s.toInt())
                continue
            }

            val num2 = arrayDeque.removeLast()
            val num1 = arrayDeque.removeLast()
            val result = when (s) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                else -> num1 / num2
            }
            arrayDeque.addLast(result)
        }
        return arrayDeque.last()
    }
}
