import kotlin.collections.ArrayDeque

class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            when(c) {
                '(', '[', '{' -> stack.addLast(c)
                ')' -> {
                    val pair = stack.removeLastOrNull()
                    if (pair != '(') return false
                }
                ']' -> {
                    val pair = stack.removeLastOrNull()
                    if (pair != '[') return false
                }
                '}' -> {
                    val pair = stack.removeLastOrNull()
                    if (pair != '{') return false
                }
            }
        }
        return stack.isEmpty()
    }
}
