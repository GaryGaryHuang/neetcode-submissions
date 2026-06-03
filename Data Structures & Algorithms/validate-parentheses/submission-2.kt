import kotlin.collections.ArrayDeque

class Solution {
    fun isValid(s: String): Boolean {
        val map = mapOf('(' to ')', '{' to '}', '[' to ']')
        val arrayDeque = ArrayDeque<Char>()
        for (c in s) {
            if (c in map) {
                arrayDeque.add(c)
            } else {
                val open = arrayDeque.removeLastOrNull() ?: return false
                if (map[open] != c) return false
            }
        }
        return arrayDeque.isEmpty()
    }
}
