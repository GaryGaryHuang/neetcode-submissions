/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        var carry = 0

        val dummy = ListNode(0)
        var current = dummy
        while (node1 != null || node2 != null || carry > 0) {
            var num = carry
            node1?.`val`?.let { num += it }
            node2?.`val`?.let { num += it }
            val node = ListNode(num % 10)
            current.next = node
            current = node
            carry = num / 10

            node1 = node1?.next
            node2 = node2?.next
        }
        return dummy.next
    }
}
