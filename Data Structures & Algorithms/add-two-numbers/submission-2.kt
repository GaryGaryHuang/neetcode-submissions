/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var prev = dummy

        var carry = 0
        var node1 = l1
        var node2 = l2
        while (carry > 0 || node1 != null || node2 != null) {
            val total = carry + (node1?.`val` ?: 0) + (node2?.`val` ?: 0) 
            val current = ListNode(total % 10)
            prev.next = current
            prev = current
            carry = total / 10

            node1 = node1?.next
            node2 = node2?.next
        }
        return dummy.next
    }
}
