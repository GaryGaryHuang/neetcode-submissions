import kotlin.collections.ArrayDeque

class Solution {
    fun isValid(s: String): Boolean {
        val openSet = setOf('(', '{', '[')
        val map = mutableMapOf('(' to ')', '{' to '}', '[' to ']')
        val arrayDeque = ArrayDeque<Char>()
        for (c in s) {
            if (c in openSet) {
                arrayDeque.add(c)
            } else {
                val open = arrayDeque.removeLastOrNull() ?: return false
                if (map[open] != c) return false
            }
        }
        return arrayDeque.isEmpty()
    }
}
