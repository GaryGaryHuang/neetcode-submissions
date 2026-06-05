/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0).apply {
            next = head
        }

        var fast = head
        repeat(n) {
            if (fast == null) return@repeat
            fast = fast.next
        }

        var prev = dummy
        var slow = head
        while (fast != null) {
            fast = fast.next
            prev = slow!!
            slow = slow!!.next
        }
        prev!!.next = slow!!.next

        return dummy.next
    }
}
